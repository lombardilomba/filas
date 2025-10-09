package com.example.filas.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class AtributoPropostaDTOBuilder {

    private AtributoPropostaDTOBuilder() {
        // utility class
    }

    public static IdStep builder() {
        return new Builder();
    }

    public interface IdStep {
        PropostaIdStep id(Long id);
    }

    public interface PropostaIdStep {
        ClienteNomeStep propostaId(Long propostaId);
    }

    public interface ClienteNomeStep {
        ClientePerfilStep clienteNome(String clienteNome);
    }

    public interface ClientePerfilStep {
        ClienteClassificacaoStep clientePerfil(String clientePerfil);
    }

    public interface ClienteClassificacaoStep {
        OperadorNomeStep clienteClassificacao(Integer clienteClassificacao);
    }

    public interface OperadorNomeStep {
        OperadorCodigoStep operadorNome(String operadorNome);
    }

    public interface OperadorCodigoStep {
        AgenteClassificacaoStep operadorCodigo(String operadorCodigo);
    }

    public interface AgenteClassificacaoStep {
        LojistaClassificacaoStep agenteClassificacao(String agenteClassificacao);
    }

    public interface LojistaClassificacaoStep {
        ValorCreditoStep lojistaClassificacao(String lojistaClassificacao);
    }

    public interface ValorCreditoStep {
        EntradaPercentualStep valorCredito(BigDecimal valorCredito);
    }

    public interface EntradaPercentualStep {
        LocalStep entradaPercentual(BigDecimal entradaPercentual);
    }

    public interface LocalStep {
        NumeroDevolucoesStep local(Integer local);
    }

    public interface NumeroDevolucoesStep {
        AtualizadoEmStep numeroDevolucoes(Integer numeroDevolucoes);
    }

    public interface AtualizadoEmStep {
        BuildStep atualizadoEm(LocalDateTime atualizadoEm);
    }

    public interface BuildStep {
        AtributoPropostaDTO build();
    }

    private static final class Builder implements IdStep, PropostaIdStep, ClienteNomeStep,
            ClientePerfilStep, ClienteClassificacaoStep, OperadorNomeStep, OperadorCodigoStep,
            AgenteClassificacaoStep, LojistaClassificacaoStep, ValorCreditoStep,
            EntradaPercentualStep, LocalStep, NumeroDevolucoesStep, AtualizadoEmStep, BuildStep {

        private final AtributoPropostaDTO instancia = new AtributoPropostaDTO();

        @Override
        public PropostaIdStep id(Long id) {
            instancia.setId(id);
            return this;
        }

        @Override
        public ClienteNomeStep propostaId(Long propostaId) {
            instancia.setPropostaId(propostaId);
            return this;
        }

        @Override
        public ClientePerfilStep clienteNome(String clienteNome) {
            instancia.setClienteNome(clienteNome);
            return this;
        }

        @Override
        public ClienteClassificacaoStep clientePerfil(String clientePerfil) {
            instancia.setClientePerfil(clientePerfil);
            return this;
        }

        @Override
        public OperadorNomeStep clienteClassificacao(Integer clienteClassificacao) {
            instancia.setClienteClassificacao(clienteClassificacao);
            return this;
        }

        @Override
        public OperadorCodigoStep operadorNome(String operadorNome) {
            instancia.setOperadorNome(operadorNome);
            return this;
        }

        @Override
        public AgenteClassificacaoStep operadorCodigo(String operadorCodigo) {
            instancia.setOperadorCodigo(operadorCodigo);
            return this;
        }

        @Override
        public LojistaClassificacaoStep agenteClassificacao(String agenteClassificacao) {
            instancia.setAgenteClassificacao(agenteClassificacao);
            return this;
        }

        @Override
        public ValorCreditoStep lojistaClassificacao(String lojistaClassificacao) {
            instancia.setLojistaClassificacao(lojistaClassificacao);
            return this;
        }

        @Override
        public EntradaPercentualStep valorCredito(BigDecimal valorCredito) {
            instancia.setValorCredito(valorCredito);
            return this;
        }

        @Override
        public LocalStep entradaPercentual(BigDecimal entradaPercentual) {
            instancia.setEntradaPercentual(entradaPercentual);
            return this;
        }

        @Override
        public NumeroDevolucoesStep local(Integer local) {
            instancia.setLocal(local);
            return this;
        }

        @Override
        public AtualizadoEmStep numeroDevolucoes(Integer numeroDevolucoes) {
            instancia.setNumeroDevolucoes(numeroDevolucoes);
            return this;
        }

        @Override
        public BuildStep atualizadoEm(LocalDateTime atualizadoEm) {
            instancia.setAtualizadoEm(atualizadoEm);
            return this;
        }

        @Override
        public AtributoPropostaDTO build() {
            return instancia;
        }
    }
}
