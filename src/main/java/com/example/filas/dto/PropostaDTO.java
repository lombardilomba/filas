package com.example.filas.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PropostaDTO {

    private Long id;
    private Long numeroProposta;
    private String origem;
    private String filaAtual;
    private String perfil;
    private String clienteCpf;
    private String grupo2;
    private String agenteNome;
    private String agenteCodigo;
    private String cidade;
    private String lojistaNome;
    private String tipoCliente;
    private String tipoLojista;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataUltimoEnvioFila;
    private LocalDateTime atualizadoEm;
    private AtributoPropostaDTO atributoProposta;
    private List<AnaliseDTO> analises = new ArrayList<>();
}
