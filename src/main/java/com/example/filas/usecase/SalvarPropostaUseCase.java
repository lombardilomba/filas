package com.example.filas.usecase;

import com.example.filas.domain.Proposta;
import com.example.filas.dto.PropostaDTO;
import com.example.filas.mapper.PropostaMapper;
import com.example.filas.repository.facade.PropostaRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarPropostaUseCase {

    private final PropostaRepositoryFacade propostaRepositoryFacade;

    public PropostaDTO execute(PropostaDTO propostaDTO) {
        if (propostaDTO == null) {
            throw new IllegalArgumentException("PropostaDTO não pode ser nulo");
        }
        Proposta proposta = PropostaMapper.toEntity(propostaDTO);
        Proposta propostaSalva = propostaRepositoryFacade.save(proposta);
        return PropostaMapper.toDto(propostaSalva);
    }
}
