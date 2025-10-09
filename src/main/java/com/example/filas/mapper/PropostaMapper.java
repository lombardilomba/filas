package com.example.filas.mapper;

import com.example.filas.domain.AtributoPropostaEntity;
import com.example.filas.domain.AnaliseEntity;
import com.example.filas.domain.PropostaEntity;
import com.example.filas.dto.AtributoPropostaDTO;
import com.example.filas.dto.AnaliseDTO;
import com.example.filas.dto.PropostaDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class PropostaMapper {

    private PropostaMapper() {
    }

    public static PropostaDTO toDto(PropostaEntity proposta) {
        if (proposta == null) {
            return null;
        }

        PropostaDTO dto = new PropostaDTO();
        dto.setId(proposta.getId());
        dto.setNumeroProposta(proposta.getNumeroProposta());
        dto.setOrigem(proposta.getOrigem());
        dto.setFilaAtual(proposta.getFilaAtual());
        dto.setPerfil(proposta.getPerfil());
        dto.setClienteCpf(proposta.getClienteCpf());
        dto.setGrupo2(proposta.getGrupo2());
        dto.setAgenteNome(proposta.getAgenteNome());
        dto.setAgenteCodigo(proposta.getAgenteCodigo());
        dto.setCidade(proposta.getCidade());
        dto.setLojistaNome(proposta.getLojistaNome());
        dto.setTipoCliente(proposta.getTipoCliente());
        dto.setTipoLojista(proposta.getTipoLojista());
        dto.setDataCriacao(proposta.getDataCriacao());
        dto.setDataUltimoEnvioFila(proposta.getDataUltimoEnvioFila());
        dto.setAtualizadoEm(proposta.getAtualizadoEm());

        dto.setAtributoProposta(AtributoPropostaMapper.toDto(proposta.getAtributoProposta()));
        dto.setAnalises(mapAnalisesToDto(proposta.getAnalises()));
        return dto;
    }

    public static PropostaEntity toEntity(PropostaDTO dto) {
        if (dto == null) {
            return null;
        }

        PropostaEntity proposta = new PropostaEntity();
        proposta.setId(dto.getId());
        proposta.setNumeroProposta(dto.getNumeroProposta());
        proposta.setOrigem(dto.getOrigem());
        proposta.setFilaAtual(dto.getFilaAtual());
        proposta.setPerfil(dto.getPerfil());
        proposta.setClienteCpf(dto.getClienteCpf());
        proposta.setGrupo2(dto.getGrupo2());
        proposta.setAgenteNome(dto.getAgenteNome());
        proposta.setAgenteCodigo(dto.getAgenteCodigo());
        proposta.setCidade(dto.getCidade());
        proposta.setLojistaNome(dto.getLojistaNome());
        proposta.setTipoCliente(dto.getTipoCliente());
        proposta.setTipoLojista(dto.getTipoLojista());
        proposta.setDataCriacao(dto.getDataCriacao());
        proposta.setDataUltimoEnvioFila(dto.getDataUltimoEnvioFila());
        proposta.setAtualizadoEm(dto.getAtualizadoEm());

        AtributoPropostaDTO atributoPropostaDTO = dto.getAtributoProposta();
        if (atributoPropostaDTO != null) {
            AtributoPropostaEntity atributoProposta = AtributoPropostaMapper.toEntity(atributoPropostaDTO);
            proposta.setAtributoProposta(atributoProposta);
        }

        List<AnaliseDTO> analisesDTO = dto.getAnalises();
        if (analisesDTO != null) {
            List<AnaliseEntity> analises = analisesDTO.stream()
                    .map(AnaliseMapper::toEntity)
                    .collect(Collectors.toList());
            proposta.setAnalises(analises);
        } else {
            proposta.setAnalises(Collections.emptyList());
        }

        return proposta;
    }

    private static List<AnaliseDTO> mapAnalisesToDto(List<AnaliseEntity> analises) {
        if (analises == null) {
            return new ArrayList<>();
        }
        return analises.stream()
                .map(AnaliseMapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
