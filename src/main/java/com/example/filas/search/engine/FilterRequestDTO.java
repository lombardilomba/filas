package com.example.filas.search.engine;

import lombok.Data;

import java.util.List;

/**
 * Request base
 */
@Data
public class FilterRequestDTO {

    private List<FilterDTO> filters;

}
