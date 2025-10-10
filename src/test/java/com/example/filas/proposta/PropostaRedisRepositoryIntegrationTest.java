package com.example.filas.proposta;

import com.example.filas.config.MockRabbitTestConfig;
import com.example.filas.domain.AtributoPropostaEntity;
import com.example.filas.domain.PropostaEntity;
import com.example.filas.repository.AtributoPropostaRepository;
import com.example.filas.repository.PropostaRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.math.BigDecimal;
import java.net.ServerSocket;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.TestPropertySource;
import redis.embedded.RedisServer;

@ActiveProfiles("test")
@SpringBootTest
@Import(MockRabbitTestConfig.class)
@TestPropertySource(properties = "filas.queue.proposta=" + PropostaRedisRepositoryIntegrationTest.PROPOSTA_QUEUE)
class PropostaRedisRepositoryIntegrationTest {

    static final String PROPOSTA_QUEUE = "proposta.queue.test";

    private static RedisServer redisServer;
    private static int redisPort;

    @DynamicPropertySource
    static void configureRedis(DynamicPropertyRegistry registry) {
        ensureRedisServerStarted();
        registry.add("spring.data.redis.host", () -> "localhost");
        registry.add("spring.data.redis.port", () -> redisPort);
    }

    @Autowired
    private PropostaRedisRepository redisRepository;

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AtributoPropostaRepository atributoPropostaRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @AfterEach
    void cleanUp() {
        propostaRepository.deleteAll();
        stringRedisTemplate.getConnectionFactory()
                .getConnection()
                .serverCommands()
                .flushAll();
    }

    @AfterAll
    static void shutdownRedis() {
        if (redisServer != null && redisServer.isActive()) {
            redisServer.stop();
        }
    }

    @Test
    @DisplayName("Deve persistir a proposta no banco e replicar dados básicos no Redis")
    void devePersistirNoBancoELerDoRedis() {
        PropostaEntity propostaEntity = new PropostaEntity();
        propostaEntity.setNumeroProposta(1001L);
        propostaEntity.setOrigem("app");
        propostaEntity.setFilaAtual("fila_principal");
        propostaEntity.setPerfil("cliente");
        propostaEntity.setClienteCpf("12345678900");

        AtributoPropostaEntity atributo = new AtributoPropostaEntity();
        atributo.setValorCredito(new BigDecimal("1500.00"));
        propostaEntity.setAtributoProposta(atributo);

        PropostaEntity salva = propostaRepository.save(propostaEntity);

        PropostaEntity carregada = propostaRepository.findById(salva.getId()).orElseThrow();
        AtributoPropostaEntity atributoCarregado = atributoPropostaRepository.findById(carregada.getId()).orElseThrow();

        assertThat(carregada.getNumeroProposta()).isEqualTo(1001L);
        assertThat(carregada.getClienteCpf()).isEqualTo("12345678900");
        assertThat(atributoCarregado.getValorCredito()).isEqualByComparingTo("1500.00");

        Proposta proposta = new Proposta(
                String.valueOf(carregada.getNumeroProposta()),
                carregada.getClienteCpf(),
                atributoCarregado.getValorCredito()
        );

        redisRepository.save(proposta);
        Optional<Proposta> encontrada = redisRepository.findById(proposta.id());

        assertThat(encontrada).contains(proposta);
    }

    private static void ensureRedisServerStarted() {
        if (redisServer == null) {
            redisPort = findFreePort();
            redisServer = RedisServer.builder()
                    .port(redisPort)
                    .setting("maxmemory 8M")
                    .setting("bind 127.0.0.1")
                    .build();
            redisServer.start();
        }
    }

    private static int findFreePort() {
        try (ServerSocket socket = new ServerSocket(0)) {
            socket.setReuseAddress(true);
            return socket.getLocalPort();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível encontrar uma porta livre para o Redis", e);
        }
    }
}
