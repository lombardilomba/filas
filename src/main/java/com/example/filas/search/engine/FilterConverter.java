package com.example.filas.search.engine;

import org.springframework.stereotype.Component;

@Component
public class FilterConverter {

    public SpecificationFilterDTO convert(FilterRequestDTO request) {

        SpecificationFilterDTO dto = new SpecificationFilterDTO();

        for (FilterDTO filter : request.getFilters()) {
            FilterAttribute attr = FilterAttribute.from(filter.getAttribute());
            dto.add(attr, filter.getValues());
        }

        return dto;
    }
}
