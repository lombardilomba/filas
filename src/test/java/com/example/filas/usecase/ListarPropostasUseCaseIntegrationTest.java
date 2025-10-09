package com.example.filas.usecase;

import static com.example.filas.usecase.support.PropostaTestDataFactory.novaProposta;

import com.example.filas.dto.PropostaDTO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ListarPropostasUseCaseIntegrationTest {

    @Autowired
    private SalvarPropostaUseCase salvarPropostaUseCase;

    @Autowired
    private ListarPropostasUseCase listarPropostasUseCase;

    @Test
    void deveListarTodasPropostas() {
        salvarPropostaUseCase.execute(novaProposta(3001L, "APROVACAO"));
        salvarPropostaUseCase.execute(novaProposta(3002L, "REANALISE"));

        List<PropostaDTO> propostas = listarPropostasUseCase.execute(null);

        Assertions.assertEquals(2, propostas.size());
        Assertions.assertTrue(propostas.stream().anyMatch(dto -> dto.getNumeroProposta().equals(3001L)));
        Assertions.assertTrue(propostas.stream().anyMatch(dto -> dto.getNumeroProposta().equals(3002L)));
    }
}
