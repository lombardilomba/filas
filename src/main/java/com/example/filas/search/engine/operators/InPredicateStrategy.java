package com.example.filas.search.engine.operators;

import com.example.filas.search.engine.PredicateStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

import java.util.List;

public class InPredicateStrategy implements PredicateStrategy {

    @Override
    public Predicate build(CriteriaBuilder criteriaBuilder, Path<?> path, List<?> values) {
        return path.in(values);
    }
}
