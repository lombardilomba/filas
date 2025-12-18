package com.example.filas.search.engine;

import com.example.filas.domain.PropostaEntity;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Converte SpecificationFilterDTO para uma Specification do objeto
 * Aplicando os filters com suas operacoes
 */

public class PropostaSpecification {

    public static Specification<PropostaEntity> build(SpecificationFilterDTO filters) {

        return (Root<PropostaEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            filters.getFilters().forEach((attribute, values) -> {

                if (values == null || values.isEmpty()) {
                    return;
                }

                Path<?> path = root.get(attribute.getField());

                Predicate predicate = attribute.getStrategy().build(criteriaBuilder, path, values);

                predicates.add(predicate);
            });

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}