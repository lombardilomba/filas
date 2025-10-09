package com.example.filas.mapper;

import com.example.filas.domain.AnaliseEntity;
import com.example.filas.domain.PropostaEntity;
import com.example.filas.dto.AnaliseDTO;
public final class AnaliseMapper {

    private AnaliseMapper() {
    }

    public static AnaliseDTO toDto(AnaliseEntity analise) {
        if (analise == null) {
            return null;
        }

        AnaliseDTO dto = new AnaliseDTO();
        dto.setId(analise.getId());
        dto.setPropostaId(analise.getProposta() != null ? analise.getProposta().getId() : null);
        dto.setTipoFila(analise.getTipoFila());
        dto.setDataEntrada(analise.getDataEntrada());
        dto.setDataInicio(analise.getDataInicio());
        dto.setAnalistaAtribuidoId(analise.getAnalistaAtribuidoId());
        dto.setAnalistaAtualId(analise.getAnalistaAtualId());
        dto.setPrioridade(analise.getPrioridade());
        return dto;
    }

    public static AnaliseEntity toEntity(AnaliseDTO dto) {
        if (dto == null) {
            return null;
        }

        AnaliseEntity analise = new AnaliseEntity();
        analise.setId(dto.getId());
        if (dto.getPropostaId() != null) {
            PropostaEntity proposta = new PropostaEntity();
            proposta.setId(dto.getPropostaId());
            analise.setProposta(proposta);
        }
        analise.setTipoFila(dto.getTipoFila());
        analise.setDataEntrada(dto.getDataEntrada());
        analise.setDataInicio(dto.getDataInicio());
        analise.setAnalistaAtribuidoId(dto.getAnalistaAtribuidoId());
        analise.setAnalistaAtualId(dto.getAnalistaAtualId());
        analise.setPrioridade(dto.getPrioridade());
        return analise;
    }
}
