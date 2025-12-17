package com.example.filas.search.engine;

import com.example.filas.domain.PropostaEntity;
import com.example.filas.repository.PropostaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class PropostaSpecificationIntegrationTest {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private FilterConverter filterConverter;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveAplicarFiltros() {

        SpecificationFilterDTO filters = new SpecificationFilterDTO();

        filters.add(FilterAttribute.ORIGEM, List.of("omni+", "omnifacil"));
        filters.add(FilterAttribute.AGENTE_CODIGO, List.of("330"));

        filters.add(FilterAttribute.CIDADE, List.of("São Paulo", "Campinas"));

        List<PropostaEntity> result = propostaRepository.findAll(PropostaSpecification.build(filters));

        Assertions.assertEquals(2, result.size());
    }

    @Test
    void deveConverterJsonEListar() throws Exception {
        String json = """
            {
              "filters": [
                { "attribute": "origem", "values": ["omni+", "omnifacil"] },
                { "attribute": "agente_codigo", "values": ["330"] },
                { "attribute": "cidade", "values": ["São Paulo", "Campinas"] }
              ]
            }
            """;

        FilterRequestDTO request = objectMapper.readValue(json, FilterRequestDTO.class);

        SpecificationFilterDTO specFilters = filterConverter.convert(request);

        List<PropostaEntity> result = propostaRepository.findAll(PropostaSpecification.build(specFilters));

        Assertions.assertEquals(2, result.size());
    }

}
