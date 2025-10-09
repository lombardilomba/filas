package com.example.filas.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnaliseDTO {

    private Long id;
    private Long propostaId;
    private String tipoFila;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataInicio;
    private String analistaAtribuidoId;
    private String analistaAtualId;
    private String prioridade;
}
