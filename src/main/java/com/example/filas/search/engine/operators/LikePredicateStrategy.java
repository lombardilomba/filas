package com.example.filas.search.engine.operators;

import com.example.filas.search.engine.PredicateStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

import java.util.List;

public class LikePredicateStrategy implements PredicateStrategy {

    @Override
    public Predicate build(CriteriaBuilder criteriaBuilder, Path<?> path, List<?> values) {
        String value = values.get(0).toString().toLowerCase();
        return criteriaBuilder.like(criteriaBuilder.lower(path.as(String.class)), "%" + value + "%");
    }
}
