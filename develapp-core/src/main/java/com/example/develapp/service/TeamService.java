package com.example.develapp.service;


import com.example.develapp.jpa.Team;
import com.example.develapp.mapper.TeamMapper;
import com.example.develapp.model.TeamDto;
import com.example.develapp.repository.GenericSpecification;
import com.example.develapp.repository.TeamRepository;
import com.example.develapp.request.TeamFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    private TeamDto mapper(Team team) {
        return TeamDto.builder()
                      .city(team.getCity())
                      .teamName(team.getTeamName())
                      .country(team.getCountry())
                      .id(team.getId())
                      .build();
    }

    public Page<TeamDto> getTeamsPage(Pageable pageable) {
        return teamRepository.findAll(pageable)
                             .map(this::mapper);
    }

    public Page<TeamDto> getTeamsPageFilter(TeamFilter teamFilter, Pageable pageable) {
//        Specification<Team> specificationForFilters = TeamSpecification.getSpecificationForFilters(teamFilter);
//        TeamSpecification specificationForFilters = new TeamSpecification(teamFilter);
//        return teamRepository.findAll(specificationForFilters, pageable)
//                             .map(TeamMapper::map);
        return Page.empty();
    }

    public Page<TeamDto> getTeamsPageFilter(Map<String, String> params, Pageable pageable) {
        Map<String, String> map = new HashMap<>();

        for(Field field :Team.class.getDeclaredFields()){
                String columnName;
                if (field.isAnnotationPresent(Column.class)) {
                    columnName = field.getName();
                    String string = params.get(columnName);
                    if (string != null) {
                        map.put(columnName, string);
                }
            }
        }

        GenericSpecification<Team> teamGenericSpecification = new GenericSpecification<>(map);

        return teamRepository.findAll(teamGenericSpecification, pageable)
                             .map(TeamMapper::map);
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

    public List<Team> getTeams(int limit) {
        return teamRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }

    public Team createTeam(String teamName, String city, String country) {
        return teamRepository.save(Team.builder()
                                       .teamName(teamName)
                                       .city(city)
                                       .country(country)
                                       .build());
    }

}
