package com.example.filas.search.engine.operators;

import com.example.filas.search.engine.PredicateStrategy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

import java.util.List;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class GreaterOrEqualPredicateStrategy implements PredicateStrategy {

    @Override
    public Predicate build(CriteriaBuilder criteriaBuilder, Path<?> path, List<?> values) {
        Comparable value = (Comparable) values.get(0);
        return criteriaBuilder.greaterThanOrEqualTo((Path<Comparable>) path, value);
    }
}
