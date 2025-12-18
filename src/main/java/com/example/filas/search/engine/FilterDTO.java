package com.example.filas.search.engine;

import lombok.Data;

import java.util.List;

/**
 * Conteudo da request base
 */
@Data
public class FilterDTO {
    private String attribute;
    private List<String> values;
}
