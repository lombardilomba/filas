package com.example.filas.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AtributoPropostaDTO {

    private Long id;
    private Long propostaId;
    private String clienteNome;
    private String clientePerfil;
    private Integer clienteClassificacao;
    private String operadorNome;
    private String operadorCodigo;
    private String agenteClassificacao;
    private String lojistaClassificacao;
    private BigDecimal valorCredito;
    private BigDecimal entradaPercentual;
    private Integer local;
    private Integer numeroDevolucoes;
    private LocalDateTime atualizadoEm;
}
