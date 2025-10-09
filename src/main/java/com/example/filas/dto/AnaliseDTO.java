package com.example.filas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnaliseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("proposalId")
    private Long propostaId;

    @JsonProperty("queueType")
    private String tipoFila;

    @JsonProperty("entryDate")
    private LocalDateTime dataEntrada;

    @JsonProperty("startDate")
    private LocalDateTime dataInicio;

    @JsonProperty("assignedAnalystId")
    private String analistaAtribuidoId;

    @JsonProperty("currentAnalystId")
    private String analistaAtualId;

    @JsonProperty("priority")
    private String prioridade;
}
