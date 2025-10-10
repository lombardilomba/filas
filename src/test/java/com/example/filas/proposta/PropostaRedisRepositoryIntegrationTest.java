package com.example.filas.proposta;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PropostaRedisRepositoryIntegrationTest {

    @Autowired
    private PropostaRedisRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StringRedisTemplate stringRedisTemplate;

    private ValueOperations<String, String> valueOperations;

    @BeforeEach
    void setUp() {
        valueOperations = Mockito.mock(ValueOperations.class);
        when(stringRedisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    @DisplayName("Deve salvar a proposta convertida em JSON no Redis")
    void deveSalvarPropostaNoRedis() throws Exception {
        Proposta proposta = new Proposta("123", "12345678900", new BigDecimal("1500.00"));

        repository.save(proposta);

        ArgumentCaptor<String> valueCaptor = ArgumentCaptor.forClass(String.class);
        verify(valueOperations).set("proposta:" + proposta.id(), valueCaptor.capture());

        Proposta propostaSalva = objectMapper.readValue(valueCaptor.getValue(), Proposta.class);
        assertThat(propostaSalva).isEqualTo(proposta);
    }

    @Test
    @DisplayName("Deve recuperar a proposta armazenada no Redis")
    void deveRecuperarPropostaNoRedis() throws Exception {
        Proposta proposta = new Proposta("456", "98765432100", new BigDecimal("2500.00"));
        String json = objectMapper.writeValueAsString(proposta);
        when(valueOperations.get("proposta:" + proposta.id())).thenReturn(json);

        Optional<Proposta> encontrada = repository.findById(proposta.id());

        assertThat(encontrada).contains(proposta);
    }
}
