package com.example.filas.mapper;

import com.example.filas.domain.Analise;
import com.example.filas.domain.Proposta;
import com.example.filas.dto.AnaliseDTO;
import org.springframework.stereotype.Component;

@Component
public class AnaliseMapper {

    public AnaliseDTO toDto(Analise analise) {
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

    public Analise toEntity(AnaliseDTO dto) {
        if (dto == null) {
            return null;
        }

        Analise analise = new Analise();
        analise.setId(dto.getId());
        if (dto.getPropostaId() != null) {
            Proposta proposta = new Proposta();
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
