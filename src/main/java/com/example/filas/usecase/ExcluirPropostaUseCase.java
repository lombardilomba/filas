package com.example.filas.usecase;

import com.example.filas.dto.PropostaDTO;
import com.example.filas.repository.facade.PropostaRepositoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExcluirPropostaUseCase {

    private final PropostaRepositoryFacade propostaRepositoryFacade;

    public void execute(PropostaDTO propostaDTO) {
        if (propostaDTO == null || propostaDTO.getId() == null) {
            throw new IllegalArgumentException("É necessário informar o identificador da proposta");
        }

        propostaRepositoryFacade.deleteById(propostaDTO.getId());
    }
}
