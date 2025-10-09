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
class BuscarPropostaPorIdUseCaseIntegrationTest {

    @Autowired
    private SalvarPropostaUseCase salvarPropostaUseCase;

    @Autowired
    private BuscarPropostaPorIdUseCase buscarPropostaPorIdUseCase;

    @Test
    void deveEncontrarPropostaPeloId() {
        PropostaDTO propostaSalva = salvarPropostaUseCase.execute(novaProposta(2001L, "TRIAGEM"));

        PropostaDTO filtro = new PropostaDTO();
        filtro.setId(propostaSalva.getId());

        PropostaDTO propostaEncontrada = buscarPropostaPorIdUseCase.execute(filtro);

        Assertions.assertNotNull(propostaEncontrada);
        Assertions.assertEquals(propostaSalva.getId(), propostaEncontrada.getId());
        Assertions.assertEquals("CANAL_DIGITAL", propostaEncontrada.getOrigem());
        Assertions.assertEquals("Cliente 2001", propostaEncontrada.getAtributoProposta().getClienteNome());
        Assertions.assertEquals(1, propostaEncontrada.getAnalises().size());
        Assertions.assertEquals("TRIAGEM", propostaEncontrada.getAnalises().get(0).getTipoFila());
    }
}
