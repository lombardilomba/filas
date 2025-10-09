package com.example.filas.repository.facade;

import com.example.filas.domain.Proposta;
import com.example.filas.repository.PropostaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PropostaRepositoryFacade {

    private final PropostaRepository propostaRepository;

    public Proposta save(Proposta proposta) {
        return propostaRepository.save(proposta);
    }

    public Optional<Proposta> findById(Long id) {
        return propostaRepository.findById(id);
    }

    public List<Proposta> findAll() {
        return propostaRepository.findAll();
    }

    public void deleteById(Long id) {
        propostaRepository.deleteById(id);
    }
}
