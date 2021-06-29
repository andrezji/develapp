package com.example.develapp.service;

import com.example.develapp.jpa.Team;
import com.example.develapp.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class TeamQueryService extends QueryService<Team> {

    public TeamQueryService(TeamRepository teamRepository) {
        super(teamRepository);
    }

}
