package com.example.filas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "atributo_proposta")
public class AtributoPropostaEntity {

    @Id
    @Column(name = "atributo_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "proposta_id")
    private PropostaEntity proposta;

    @Column(name = "cliente_nome")
    private String clienteNome;

    @Column(name = "cliente_perfil")
    private String clientePerfil;

    @Column(name = "cliente_classificacao")
    private Integer clienteClassificacao;

    @Column(name = "operador_nome")
    private String operadorNome;

    @Column(name = "operador_codigo")
    private String operadorCodigo;

    @Column(name = "agente_classificacao")
    private String agenteClassificacao;

    @Column(name = "lojista_classificacao")
    private String lojistaClassificacao;

    @Column(name = "valor_credito")
    private BigDecimal valorCredito;

    @Column(name = "entrada_percentual")
    private BigDecimal entradaPercentual;

    @Column(name = "local")
    private Integer local;

    @Column(name = "numero_devolucoes")
    private Integer numeroDevolucoes;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
}
