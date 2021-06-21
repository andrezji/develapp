package com.example.develapp.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.develapp.jpa.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMutation implements GraphQLMutationResolver {

    private TeamService teamService;

    public TeamMutation(TeamService teamService) {
        this.teamService = teamService;
    }

    public Team createT(String teamName, String city, String country) {
        return teamService.createTeam(teamName, city, country);
    }
}
