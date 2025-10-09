package com.example.filas.usecase;

import static com.example.filas.usecase.support.PropostaTestDataFactory.novaProposta;

import com.example.filas.dto.PropostaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class SalvarPropostaUseCaseIntegrationTest {

    @Autowired
    private SalvarPropostaUseCase salvarPropostaUseCase;

    @Test
    void devePersistirPropostaComAssociacoes() {
        PropostaDTO propostaSalva = salvarPropostaUseCase.execute(novaProposta(1001L, "INICIAL"));

        Assertions.assertNotNull(propostaSalva.getId());
        Assertions.assertEquals("CANAL_DIGITAL", propostaSalva.getOrigem());
        Assertions.assertNotNull(propostaSalva.getAtributoProposta());
        Assertions.assertEquals("Cliente 1001", propostaSalva.getAtributoProposta().getClienteNome());
        Assertions.assertEquals(1, propostaSalva.getAnalises().size());
        Assertions.assertEquals("INICIAL", propostaSalva.getAnalises().get(0).getTipoFila());
    }
}
