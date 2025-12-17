package com.example.filas.search.engine;

import com.example.filas.domain.PropostaEntity;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PropostaSpecification {

    public static Specification<PropostaEntity> build(SpecificationFilterDTO filters) {

        return (Root<PropostaEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            filters.getFilters().forEach((attribute, values) -> {

                if (values == null || values.isEmpty()) {
                    return;
                }

                Path<?> path = root.get(attribute.getField());

                //caso seja um tipo especifico, tipo buscar com like muda aqui com ifzinho se for o caso (nao precisa ser if)

                predicates.add(path.in(values));
            });

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}