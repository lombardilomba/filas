package com.example.filas.search.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecificationFilterDTO {

    private final Map<FilterAttribute, List<?>> filters = new HashMap<>();

    public void add(FilterAttribute attribute, List<?> values) {
        filters.put(attribute, values);
    }

    public Map<FilterAttribute, List<?>> getFilters() {
        return filters;
    }
}
