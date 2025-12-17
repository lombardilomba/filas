package com.example.filas.search.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecificationFilterDTO {

    private final Map<FilterAttribute, List<String>> filters = new HashMap<>();

    public void add(FilterAttribute attribute, List<String> values) {
        filters.put(attribute, values);
    }

    public Map<FilterAttribute, List<String>> getFilters() {
        return filters;
    }

}
