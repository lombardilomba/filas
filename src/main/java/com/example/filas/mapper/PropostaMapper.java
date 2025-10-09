package com.example.filas.mapper;

import com.example.filas.domain.AtributoProposta;
import com.example.filas.domain.Analise;
import com.example.filas.domain.Proposta;
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

    public static PropostaDTO toDto(Proposta proposta) {
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

    public static Proposta toEntity(PropostaDTO dto) {
        if (dto == null) {
            return null;
        }

        Proposta proposta = new Proposta();
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
            AtributoProposta atributoProposta = AtributoPropostaMapper.toEntity(atributoPropostaDTO);
            proposta.setAtributoProposta(atributoProposta);
        }

        List<AnaliseDTO> analisesDTO = dto.getAnalises();
        if (analisesDTO != null) {
            List<Analise> analises = analisesDTO.stream()
                    .map(AnaliseMapper::toEntity)
                    .collect(Collectors.toList());
            proposta.setAnalises(analises);
        } else {
            proposta.setAnalises(Collections.emptyList());
        }

        return proposta;
    }

    private static List<AnaliseDTO> mapAnalisesToDto(List<Analise> analises) {
        if (analises == null) {
            return new ArrayList<>();
        }
        return analises.stream()
                .map(AnaliseMapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
