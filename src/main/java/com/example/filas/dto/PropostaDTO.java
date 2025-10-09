package com.example.filas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PropostaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("proposalNumber")
    private Long numeroProposta;

    @JsonProperty("origin")
    private String origem;

    @JsonProperty("currentQueue")
    private String filaAtual;

    @JsonProperty("profile")
    private String perfil;

    @JsonProperty("customerCpf")
    private String clienteCpf;

    @JsonProperty("groupTwo")
    private String grupo2;

    @JsonProperty("agentName")
    private String agenteNome;

    @JsonProperty("agentCode")
    private String agenteCodigo;

    @JsonProperty("city")
    private String cidade;

    @JsonProperty("merchantName")
    private String lojistaNome;

    @JsonProperty("customerType")
    private String tipoCliente;

    @JsonProperty("merchantType")
    private String tipoLojista;

    @JsonProperty("createdAt")
    private LocalDateTime dataCriacao;

    @JsonProperty("lastQueueSentAt")
    private LocalDateTime dataUltimoEnvioFila;

    @JsonProperty("updatedAt")
    private LocalDateTime atualizadoEm;

    @JsonProperty("proposalAttribute")
    private AtributoPropostaDTO atributoProposta;

    @JsonProperty("analyses")
    private List<AnaliseDTO> analises = new ArrayList<>();
}
