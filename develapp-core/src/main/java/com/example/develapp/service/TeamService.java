package com.example.develapp.service;


import com.example.develapp.jpa.Person;
import com.example.develapp.jpa.Team;
import com.example.develapp.mapper.TeamMapper;
import com.example.develapp.model.TeamDto;
import com.example.develapp.repository.GenericSpecification;
import com.example.develapp.repository.TeamCustomSpecification;
import com.example.develapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TeamService {

    private final TeamRepository teamRepository;


    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Page<TeamDto> getTeamsByFilters(Map<String, Object> params, Pageable pageable) {
        QueryService<Team> teamQueryService = new QueryService<>();
        GenericSpecification<Team> genericSpecification = teamQueryService.getGenericSpecification(params, Team.class);

        Specification<Team> specification = genericSpecification.and(getJoinSpecification(params));

        return teamRepository.findAll(specification, pageable).map(TeamMapper.INSTANCE::toDto);
    }

    public void create(TeamDto teamDto) {
        Team team = Team.builder()
                        .city(teamDto.getCity())
                        .teamName(teamDto.getTeamName())
                        .country(teamDto.getCountry())
                        .id(teamDto.getId())
                        .build();
        teamRepository.save(team);
    }

    private Specification<Team> getJoinSpecification(Map<String, Object> params) {
        QueryService<Person> personQueryService = new QueryService<>();
        Map<String, Object> filterMapForClass = personQueryService.getFilterMapForClass(params, Person.class);
        if (filterMapForClass.isEmpty()) {
            return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.conjunction();
        }

        return new TeamCustomSpecification(filterMapForClass);
    }

}
