package com.example.filas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "atributo_proposta")
public class AtributoProposta {

    @Id
    @Column(name = "proposta_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "proposta_id")
    private Proposta proposta;

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

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClientePerfil() {
        return clientePerfil;
    }

    public void setClientePerfil(String clientePerfil) {
        this.clientePerfil = clientePerfil;
    }

    public Integer getClienteClassificacao() {
        return clienteClassificacao;
    }

    public void setClienteClassificacao(Integer clienteClassificacao) {
        this.clienteClassificacao = clienteClassificacao;
    }

    public String getOperadorNome() {
        return operadorNome;
    }

    public void setOperadorNome(String operadorNome) {
        this.operadorNome = operadorNome;
    }

    public String getOperadorCodigo() {
        return operadorCodigo;
    }

    public void setOperadorCodigo(String operadorCodigo) {
        this.operadorCodigo = operadorCodigo;
    }

    public String getAgenteClassificacao() {
        return agenteClassificacao;
    }

    public void setAgenteClassificacao(String agenteClassificacao) {
        this.agenteClassificacao = agenteClassificacao;
    }

    public String getLojistaClassificacao() {
        return lojistaClassificacao;
    }

    public void setLojistaClassificacao(String lojistaClassificacao) {
        this.lojistaClassificacao = lojistaClassificacao;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getEntradaPercentual() {
        return entradaPercentual;
    }

    public void setEntradaPercentual(BigDecimal entradaPercentual) {
        this.entradaPercentual = entradaPercentual;
    }

    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }

    public Integer getNumeroDevolucoes() {
        return numeroDevolucoes;
    }

    public void setNumeroDevolucoes(Integer numeroDevolucoes) {
        this.numeroDevolucoes = numeroDevolucoes;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
