package com.example.develapp.repository;

import com.example.develapp.jpa.Team;
import com.example.develapp.jpa.Team_;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Map;

@AllArgsConstructor
public class TeamCustomSpecification implements Specification<Team> {


    private final Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<Team> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();
        Join<Object, Object> join = root.join(Team_.PERSONS);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            predicate =criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(
                    join.get(entry.getKey())), "%" + (entry.getValue()).toString().toLowerCase() + "%"));
        }

        return predicate;
    }


}
