package com.example.filas.usecase.support;

import com.example.filas.dto.AnaliseDTO;
import com.example.filas.dto.AtributoPropostaDTO;
import com.example.filas.dto.PropostaDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class PropostaTestDataFactory {

    private PropostaTestDataFactory() {
    }

    public static PropostaDTO novaProposta(Long numeroProposta, String filaAtual) {
        PropostaDTO dto = new PropostaDTO();
        dto.setNumeroProposta(numeroProposta);
        dto.setOrigem("CANAL_DIGITAL");
        dto.setFilaAtual(filaAtual);
        dto.setPerfil("PADRAO");
        dto.setClienteCpf("12345678900");
        dto.setGrupo2("GRUPO_TESTE");
        dto.setAgenteNome("Agente Teste");
        dto.setAgenteCodigo("AGT-" + numeroProposta);
        dto.setCidade("São Paulo");
        dto.setLojistaNome("Lojista Teste");
        dto.setTipoCliente("PF");
        dto.setTipoLojista("REVENDA");
        dto.setDataCriacao(LocalDateTime.of(2024, 1, 10, 8, 0));
        dto.setDataUltimoEnvioFila(LocalDateTime.of(2024, 1, 11, 9, 30));
        dto.setAtualizadoEm(LocalDateTime.of(2024, 1, 12, 10, 15));

        AtributoPropostaDTO atributo = new AtributoPropostaDTO();
        atributo.setClienteNome("Cliente " + numeroProposta);
        atributo.setClientePerfil("Perfil");
        atributo.setClienteClassificacao(5);
        atributo.setOperadorNome("Operador Teste");
        atributo.setOperadorCodigo("OP-" + numeroProposta);
        atributo.setAgenteClassificacao("A");
        atributo.setLojistaClassificacao("A1");
        atributo.setValorCredito(new BigDecimal("10000.00"));
        atributo.setEntradaPercentual(new BigDecimal("10.00"));
        atributo.setLocal(1);
        atributo.setNumeroDevolucoes(0);
        atributo.setAtualizadoEm(LocalDateTime.of(2024, 1, 12, 10, 15));
        dto.setAtributoProposta(atributo);

        AnaliseDTO analise = new AnaliseDTO();
        analise.setTipoFila(filaAtual);
        analise.setDataEntrada(LocalDateTime.of(2024, 1, 10, 8, 30));
        analise.setDataInicio(LocalDateTime.of(2024, 1, 10, 9, 0));
        analise.setAnalistaAtribuidoId("ANL-" + numeroProposta);
        analise.setAnalistaAtualId("ANL-" + numeroProposta);
        analise.setPrioridade("ALTA");
        dto.getAnalises().add(analise);

        return dto;
    }
}
