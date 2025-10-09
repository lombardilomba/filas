package com.example.filas.repository.facade;

import com.example.filas.domain.PropostaEntity;
import com.example.filas.repository.PropostaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PropostaRepositoryFacade {

    private final PropostaRepository propostaRepository;

    public PropostaEntity save(PropostaEntity proposta) {
        return propostaRepository.save(proposta);
    }

    public Optional<PropostaEntity> findById(Long id) {
        return propostaRepository.findById(id);
    }

    public List<PropostaEntity> findAll() {
        return propostaRepository.findAll();
    }

    public void deleteById(Long id) {
        propostaRepository.deleteById(id);
    }
}
