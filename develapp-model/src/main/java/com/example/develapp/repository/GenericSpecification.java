package com.example.develapp.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Map;

@AllArgsConstructor
public class GenericSpecification<T> implements Specification<T> {

    private final Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            predicate =criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(
                    root.get(entry.getKey())), "%" + (entry.getValue()).toString().toLowerCase() + "%"));
        }

        return predicate;
    }
}
