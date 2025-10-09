package com.example.filas.mapper;

import com.example.filas.domain.AtributoPropostaEntity;
import com.example.filas.domain.PropostaEntity;
import com.example.filas.dto.AtributoPropostaDTO;
public final class AtributoPropostaMapper {

    private AtributoPropostaMapper() {
    }

    public static AtributoPropostaDTO toDto(AtributoPropostaEntity atributoProposta) {
        if (atributoProposta == null) {
            return null;
        }

        AtributoPropostaDTO dto = new AtributoPropostaDTO();
        dto.setId(atributoProposta.getId());
        dto.setPropostaId(atributoProposta.getProposta() != null ? atributoProposta.getProposta().getId() : null);
        dto.setClienteNome(atributoProposta.getClienteNome());
        dto.setClientePerfil(atributoProposta.getClientePerfil());
        dto.setClienteClassificacao(atributoProposta.getClienteClassificacao());
        dto.setOperadorNome(atributoProposta.getOperadorNome());
        dto.setOperadorCodigo(atributoProposta.getOperadorCodigo());
        dto.setAgenteClassificacao(atributoProposta.getAgenteClassificacao());
        dto.setLojistaClassificacao(atributoProposta.getLojistaClassificacao());
        dto.setValorCredito(atributoProposta.getValorCredito());
        dto.setEntradaPercentual(atributoProposta.getEntradaPercentual());
        dto.setLocal(atributoProposta.getLocal());
        dto.setNumeroDevolucoes(atributoProposta.getNumeroDevolucoes());
        dto.setAtualizadoEm(atributoProposta.getAtualizadoEm());
        return dto;
    }

    public static AtributoPropostaEntity toEntity(AtributoPropostaDTO dto) {
        if (dto == null) {
            return null;
        }

        AtributoPropostaEntity atributoProposta = new AtributoPropostaEntity();
        atributoProposta.setId(dto.getId());
        if (dto.getPropostaId() != null) {
            PropostaEntity proposta = new PropostaEntity();
            proposta.setId(dto.getPropostaId());
            atributoProposta.setProposta(proposta);
        }
        atributoProposta.setClienteNome(dto.getClienteNome());
        atributoProposta.setClientePerfil(dto.getClientePerfil());
        atributoProposta.setClienteClassificacao(dto.getClienteClassificacao());
        atributoProposta.setOperadorNome(dto.getOperadorNome());
        atributoProposta.setOperadorCodigo(dto.getOperadorCodigo());
        atributoProposta.setAgenteClassificacao(dto.getAgenteClassificacao());
        atributoProposta.setLojistaClassificacao(dto.getLojistaClassificacao());
        atributoProposta.setValorCredito(dto.getValorCredito());
        atributoProposta.setEntradaPercentual(dto.getEntradaPercentual());
        atributoProposta.setLocal(dto.getLocal());
        atributoProposta.setNumeroDevolucoes(dto.getNumeroDevolucoes());
        atributoProposta.setAtualizadoEm(dto.getAtualizadoEm());
        return atributoProposta;
    }
}
