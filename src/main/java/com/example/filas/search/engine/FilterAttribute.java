package com.example.filas.search.engine;

import com.example.filas.search.engine.operators.EqualPredicateStrategy;
import com.example.filas.search.engine.operators.GreaterOrEqualPredicateStrategy;
import com.example.filas.search.engine.operators.InPredicateStrategy;

import java.util.Arrays;

/**
 * Chave que o client conhece e envia para o back,
 * tambem possui a referencia na fonte de dados (view ou tabela)
 */
public enum FilterAttribute {

    ORIGEM("origem", new InPredicateStrategy()),
    AGENTE_CODIGO("agenteCodigo", new EqualPredicateStrategy()),
    CIDADE("cidade", new InPredicateStrategy()),
    DATA_CRIACAO("dataCriacao", new GreaterOrEqualPredicateStrategy());

    private final String field;
    private final PredicateStrategy strategy;

    FilterAttribute(String field, PredicateStrategy strategy) {
        this.field = field;
        this.strategy = strategy;
    }

    public String getField() {
        return field;
    }

    public PredicateStrategy getStrategy() {
        return strategy;
    }

    public static FilterAttribute from(String value) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Filtro inválido: " + value)
                );
    }
}
