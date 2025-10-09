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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proposta")
public class Proposta {

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
    private AtributoProposta atributoProposta;

    @OneToMany(mappedBy = "proposta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Analise> analises = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroProposta() {
        return numeroProposta;
    }

    public void setNumeroProposta(Long numeroProposta) {
        this.numeroProposta = numeroProposta;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getFilaAtual() {
        return filaAtual;
    }

    public void setFilaAtual(String filaAtual) {
        this.filaAtual = filaAtual;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getGrupo2() {
        return grupo2;
    }

    public void setGrupo2(String grupo2) {
        this.grupo2 = grupo2;
    }

    public String getAgenteNome() {
        return agenteNome;
    }

    public void setAgenteNome(String agenteNome) {
        this.agenteNome = agenteNome;
    }

    public String getAgenteCodigo() {
        return agenteCodigo;
    }

    public void setAgenteCodigo(String agenteCodigo) {
        this.agenteCodigo = agenteCodigo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLojistaNome() {
        return lojistaNome;
    }

    public void setLojistaNome(String lojistaNome) {
        this.lojistaNome = lojistaNome;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoLojista() {
        return tipoLojista;
    }

    public void setTipoLojista(String tipoLojista) {
        this.tipoLojista = tipoLojista;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataUltimoEnvioFila() {
        return dataUltimoEnvioFila;
    }

    public void setDataUltimoEnvioFila(LocalDateTime dataUltimoEnvioFila) {
        this.dataUltimoEnvioFila = dataUltimoEnvioFila;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public AtributoProposta getAtributoProposta() {
        return atributoProposta;
    }

    public void setAtributoProposta(AtributoProposta atributoProposta) {
        this.atributoProposta = atributoProposta;
        if (atributoProposta != null) {
            atributoProposta.setProposta(this);
        }
    }

    public List<Analise> getAnalises() {
        return analises;
    }

    public void setAnalises(List<Analise> analises) {
        this.analises = analises;
    }

    public void addAnalise(Analise analise) {
        analises.add(analise);
        analise.setProposta(this);
    }

    public void removeAnalise(Analise analise) {
        analises.remove(analise);
        analise.setProposta(null);
    }
}
