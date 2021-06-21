package com.example.develapp.repository;

import com.example.develapp.jpa.Team;
import com.example.develapp.jpa.Team_;
import com.example.develapp.request.TeamFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

@AllArgsConstructor
public class TeamSpecification implements Specification<Team> {

    private final TeamFilter teamFilter;

//    public static Specification<Team> getSpecificationForFilters(TeamFilter teamFilter) {
//        Specification<Team> specification = (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
//        if (teamFilter.getName() != null) {
//            specification = specification.and(getTeamWithName(teamFilter.getName()));
//        }
//        if (teamFilter.getCity() != null) {
//            specification = specification.and(getTeamWithCity(teamFilter.getCity()));
//        }
//        if (teamFilter.getCountry() != null) {
//            specification = specification.and(getTeamWithCountry(teamFilter.getCountry()));
//        }
//        return specification;
//    }
//
//    private static Specification<Team> getTeamWithName(String name) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Team_.TEAM_NAME), name);
//    }
//
//    private static Specification<Team> getTeamWithCity(String city) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Team_.CITY), city);
//    }
//
//    private static Specification<Team> getTeamWithCountry(String country) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Team_.COUNTRY), country);
//    }

//    @Override
//    public Predicate toPredicate(Root<Team> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//
//
//        ArrayList<Predicate> predicates = new ArrayList<>();
//        if (teamFilter.getName() != null) {
//            predicates.add(criteriaBuilder.equal(root.get(Team_.TEAM_NAME), teamFilter.getName()));
//        }
//        if (teamFilter.getCity() != null) {
//            predicates.add(criteriaBuilder.equal(root.get(Team_.CITY), teamFilter.getCity()));
//        }
//        if (teamFilter.getCountry() != null) {
//            predicates.add(criteriaBuilder.equal(root.get(Team_.COUNTRY), teamFilter.getCountry()));
//        }
//
//        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//    }

    @Override
    public Predicate toPredicate(Root<Team> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        ArrayList<Predicate> predicates = new ArrayList<>();
        if (teamFilter.getName() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Team_.TEAM_NAME), teamFilter.getName()));
        }
        if (teamFilter.getCity() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Team_.CITY), teamFilter.getCity()));
        }
        if (teamFilter.getCountry() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Team_.COUNTRY), teamFilter.getCountry()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
