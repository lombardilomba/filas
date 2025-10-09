package com.example.filas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "analise")
public class Analise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analise")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposta_id", nullable = false)
    private Proposta proposta;

    @Column(name = "tipo_fila")
    private String tipoFila;

    @Column(name = "data_entrada")
    private LocalDateTime dataEntrada;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "analista_atribuido_id")
    private String analistaAtribuidoId;

    @Column(name = "analista_atual_id")
    private String analistaAtualId;

    @Column(name = "prioridade")
    private String prioridade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    public String getTipoFila() {
        return tipoFila;
    }

    public void setTipoFila(String tipoFila) {
        this.tipoFila = tipoFila;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getAnalistaAtribuidoId() {
        return analistaAtribuidoId;
    }

    public void setAnalistaAtribuidoId(String analistaAtribuidoId) {
        this.analistaAtribuidoId = analistaAtribuidoId;
    }

    public String getAnalistaAtualId() {
        return analistaAtualId;
    }

    public void setAnalistaAtualId(String analistaAtualId) {
        this.analistaAtualId = analistaAtualId;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
