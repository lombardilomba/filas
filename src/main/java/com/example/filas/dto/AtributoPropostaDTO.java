package com.example.filas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AtributoPropostaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("proposalId")
    private Long propostaId;

    @JsonProperty("customerName")
    private String clienteNome;

    @JsonProperty("customerProfile")
    private String clientePerfil;

    @JsonProperty("customerClassification")
    private Integer clienteClassificacao;

    @JsonProperty("operatorName")
    private String operadorNome;

    @JsonProperty("operatorCode")
    private String operadorCodigo;

    @JsonProperty("agentClassification")
    private String agenteClassificacao;

    @JsonProperty("merchantClassification")
    private String lojistaClassificacao;

    @JsonProperty("creditValue")
    private BigDecimal valorCredito;

    @JsonProperty("downPaymentPercentage")
    private BigDecimal entradaPercentual;

    @JsonProperty("location")
    private Integer local;

    @JsonProperty("returnCount")
    private Integer numeroDevolucoes;

    @JsonProperty("updatedAt")
    private LocalDateTime atualizadoEm;

    public static AtributoPropostaDTOBuilder.IdStep builder() {
        return AtributoPropostaDTOBuilder.builder();
    }
}
