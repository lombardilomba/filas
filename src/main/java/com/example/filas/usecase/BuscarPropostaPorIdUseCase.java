package com.example.filas.usecase;

import com.example.filas.dto.PropostaDTO;
import com.example.filas.mapper.PropostaMapper;
import com.example.filas.repository.facade.PropostaRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarPropostaPorIdUseCase {

    private final PropostaRepositoryFacade propostaRepositoryFacade;

    public PropostaDTO execute(PropostaDTO propostaDTO) {
        if (propostaDTO == null || propostaDTO.getId() == null) {
            throw new IllegalArgumentException("É necessário informar o identificador da proposta");
        }

        return propostaRepositoryFacade.findById(propostaDTO.getId())
                .map(PropostaMapper::toDto)
                .orElse(null);
    }
}
