package com.example.filas.usecase;

import com.example.filas.dto.PropostaDTO;
import com.example.filas.mapper.PropostaMapper;
import com.example.filas.repository.facade.PropostaRepositoryFacade;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListarPropostasUseCase {

    private final PropostaRepositoryFacade propostaRepositoryFacade;

    public List<PropostaDTO> execute(PropostaDTO filtro) {
        return propostaRepositoryFacade.findAll().stream()
                .map(PropostaMapper::toDto)
                .collect(Collectors.toList());
    }
}
