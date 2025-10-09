package com.example.filas.usecase;

import static com.example.filas.usecase.support.PropostaTestDataFactory.novaProposta;

import com.example.filas.dto.PropostaDTO;
import com.example.filas.repository.facade.PropostaRepositoryFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ExcluirPropostaUseCaseIntegrationTest {

    @Autowired
    private SalvarPropostaUseCase salvarPropostaUseCase;

    @Autowired
    private ExcluirPropostaUseCase excluirPropostaUseCase;

    @Autowired
    private PropostaRepositoryFacade propostaRepositoryFacade;

    @Test
    void deveExcluirPropostaECascatearAssociacoes() {
        PropostaDTO propostaSalva = salvarPropostaUseCase.execute(novaProposta(4001L, "REANALISE"));

        PropostaDTO propostaParaExcluir = new PropostaDTO();
        propostaParaExcluir.setId(propostaSalva.getId());

        excluirPropostaUseCase.execute(propostaParaExcluir);

        Assertions.assertTrue(propostaRepositoryFacade.findById(propostaSalva.getId()).isEmpty());
    }
}
