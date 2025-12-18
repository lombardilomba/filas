package com.example.filas.search.engine;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Converte de um FilterDTO para uma Specification com atributos e valores
 */

@Component
public class FilterConverter {

    public SpecificationFilterDTO convert(FilterRequestDTO request) {

        SpecificationFilterDTO dto = new SpecificationFilterDTO();

        request.getFilters().forEach(filter -> {

            FilterAttribute attr = FilterAttribute.from(filter.getAttribute());

            List<?> values = convertValues(attr, filter.getValues());

            dto.add(attr, values);
        });

        return dto;
    }

    private List<?> convertValues(FilterAttribute attr, List<String> rawValues) {

        if (attr == FilterAttribute.DATA_CRIACAO) {
            return rawValues.stream()
                    .map(LocalDateTime::parse)
                    .toList();
        }

        return rawValues;
    }
}
