package com.example.filas.messaging;

import com.example.filas.config.MockRabbitTestConfig;
import com.example.filas.config.MockRabbitTestConfig.RabbitMessagePublisher;
import com.example.filas.domain.Analise;
import com.example.filas.domain.AtributoProposta;
import com.example.filas.domain.Proposta;
import com.example.filas.dto.AnaliseDTO;
import com.example.filas.dto.AtributoPropostaDTO;
import com.example.filas.dto.PropostaDTO;
import com.example.filas.repository.AnaliseRepository;
import com.example.filas.repository.AtributoPropostaRepository;
import com.example.filas.repository.PropostaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@SpringBootTest
@Import(MockRabbitTestConfig.class)
@TestPropertySource(properties = "filas.queue.proposta=" + PropostaMessageListenerIntegrationTest.PROPOSTA_QUEUE)
class PropostaMessageListenerIntegrationTest {

    static final String PROPOSTA_QUEUE = "proposta.queue.test";

    @Autowired
    private RabbitMessagePublisher rabbitMessagePublisher;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private AtributoPropostaRepository atributoPropostaRepository;

    @Autowired
    private AnaliseRepository analiseRepository;

    @Test
    void devePersistirPropostaQuandoMensagemEhConsumida() throws JsonProcessingException {
        PropostaDTO propostaDTO = criarPropostaDTO();
        String mensagem = objectMapper.writeValueAsString(propostaDTO);

        rabbitMessagePublisher.send(PROPOSTA_QUEUE, mensagem);

        await().atMost(Duration.ofSeconds(5)).untilAsserted(() -> {
            List<Proposta> propostas = propostaRepository.findAll();
            assertThat(propostas).hasSize(1);

            Proposta proposta = propostas.get(0);
            assertThat(proposta.getNumeroProposta()).isEqualTo(12345L);
            assertThat(proposta.getOrigem()).isEqualTo("APP");
            assertThat(proposta.getClienteCpf()).isEqualTo("12345678901");

            AtributoProposta atributoProposta = atributoPropostaRepository.findById(proposta.getId()).orElse(null);
            assertThat(atributoProposta).isNotNull();
            assertThat(atributoProposta.getClienteNome()).isEqualTo("Fulano de Tal");
            assertThat(atributoProposta.getValorCredito()).isEqualByComparingTo(BigDecimal.valueOf(15000));

            List<Analise> analises = analiseRepository.findAll();
            assertThat(analises).hasSize(1);
            assertThat(analises.get(0).getTipoFila()).isEqualTo("FILA_PRINCIPAL");
        });
    }

    private PropostaDTO criarPropostaDTO() {
        PropostaDTO propostaDTO = new PropostaDTO();
        propostaDTO.setNumeroProposta(12345L);
        propostaDTO.setOrigem("APP");
        propostaDTO.setFilaAtual("FILA_PRINCIPAL");
        propostaDTO.setPerfil("PADRAO");
        propostaDTO.setClienteCpf("12345678901");
        propostaDTO.setGrupo2("GRUPO_A");
        propostaDTO.setAgenteNome("Agente X");
        propostaDTO.setAgenteCodigo("AGX-01");
        propostaDTO.setCidade("São Paulo");
        propostaDTO.setLojistaNome("Loja Central");
        propostaDTO.setTipoCliente("PESSOA_FISICA");
        propostaDTO.setTipoLojista("REDE");
        propostaDTO.setDataCriacao(LocalDateTime.now());
        propostaDTO.setDataUltimoEnvioFila(LocalDateTime.now());
        propostaDTO.setAtualizadoEm(LocalDateTime.now());

        AtributoPropostaDTO atributoPropostaDTO = new AtributoPropostaDTO();
        atributoPropostaDTO.setClienteNome("Fulano de Tal");
        atributoPropostaDTO.setClientePerfil("VIP");
        atributoPropostaDTO.setClienteClassificacao(5);
        atributoPropostaDTO.setOperadorNome("Operadora Y");
        atributoPropostaDTO.setOperadorCodigo("OPY");
        atributoPropostaDTO.setAgenteClassificacao("A");
        atributoPropostaDTO.setLojistaClassificacao("B");
        atributoPropostaDTO.setValorCredito(BigDecimal.valueOf(15000));
        atributoPropostaDTO.setEntradaPercentual(BigDecimal.valueOf(10));
        atributoPropostaDTO.setLocal(12);
        atributoPropostaDTO.setNumeroDevolucoes(0);
        atributoPropostaDTO.setAtualizadoEm(LocalDateTime.now());
        propostaDTO.setAtributoProposta(atributoPropostaDTO);

        AnaliseDTO analiseDTO = new AnaliseDTO();
        analiseDTO.setTipoFila("FILA_PRINCIPAL");
        analiseDTO.setDataEntrada(LocalDateTime.now());
        analiseDTO.setDataInicio(LocalDateTime.now());
        analiseDTO.setAnalistaAtribuidoId("ANALISTA_01");
        analiseDTO.setAnalistaAtualId("ANALISTA_02");
        analiseDTO.setPrioridade("ALTA");
        propostaDTO.setAnalises(List.of(analiseDTO));

        return propostaDTO;
    }
}
