package com.example.filas.search.engine;

import lombok.Data;

import java.util.List;

@Data
public class FilterDTO {
    private String attribute;
    private List<String> values;
}
