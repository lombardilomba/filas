package com.example.filas.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "proposta")
public class PropostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "proposta")
    private Long numeroProposta;

    @Column(name = "origem")
    private String origem;

    @Column(name = "fila_atual")
    private String filaAtual;

    @Column(name = "perfil")
    private String perfil;

    @Column(name = "cliente_cpf")
    private String clienteCpf;

    @Column(name = "grupo2")
    private String grupo2;

    @Column(name = "agente_nome")
    private String agenteNome;

    @Column(name = "agente_codigo")
    private String agenteCodigo;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "lojista_nome")
    private String lojistaNome;

    @Column(name = "tipo_cliente")
    private String tipoCliente;

    @Column(name = "tipo_lojista")
    private String tipoLojista;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultimo_envio_fila")
    private LocalDateTime dataUltimoEnvioFila;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @OneToOne(mappedBy = "proposta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AtributoPropostaEntity atributoProposta;

    @OneToMany(mappedBy = "proposta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnaliseEntity> analises = new ArrayList<>();

    public void setAtributoProposta(AtributoPropostaEntity atributoProposta) {
        this.atributoProposta = atributoProposta;
        if (atributoProposta != null) {
            atributoProposta.setProposta(this);
        }
    }

    public void setAnalises(List<AnaliseEntity> analises) {
        this.analises.clear();
        if (analises != null) {
            analises.forEach(this::addAnalise);
        }
    }

    public void addAnalise(AnaliseEntity analise) {
        if (analise == null) {
            return;
        }
        analises.add(analise);
        analise.setProposta(this);
    }

    public void removeAnalise(AnaliseEntity analise) {
        if (analise == null) {
            return;
        }
        analises.remove(analise);
        analise.setProposta(null);
    }
}
