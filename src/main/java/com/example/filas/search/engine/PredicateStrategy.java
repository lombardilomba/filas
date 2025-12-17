package com.example.filas.search.engine;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

import java.util.List;

public interface PredicateStrategy {
    Predicate build(CriteriaBuilder criteriaBuilder, Path<?> path, List<?> values);
}
