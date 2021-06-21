package com.example.develapp.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.develapp.jpa.Team;
import com.example.develapp.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TeamQuery implements GraphQLQueryResolver {

    private final TeamRepository teamRepository;

    public TeamQuery(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams(int limit) {
        return teamRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }

    public List<Team> getTeamsTest(String teamName) {
        return teamRepository.findTeamByTeamName(teamName);
    }

    public List<Team> getTeamsByCity(String city) {
        return teamRepository.findTeamByCity(city);
    }
}
