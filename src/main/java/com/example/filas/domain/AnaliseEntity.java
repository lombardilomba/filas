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
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "analise")
public class AnaliseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analise")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposta_id", nullable = false)
    private PropostaEntity proposta;

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
}
