package com.example.develapp.service;

import com.example.develapp.jpa.Team;
import com.example.develapp.model.TeamDto;
import com.example.develapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDto> getTeams() {
        List<Team> allTeams = new ArrayList<>();
        Iterable<Team> all = teamRepository.findAll();
        all.forEach(allTeams::add);

        return allTeams.stream().map(this::mapper).collect(Collectors.toList());
    }

    private TeamDto mapper(Team team) {
        if (team == null) {
            throw  new AssertionError();
        }
        return TeamDto.builder()
                .city(team.getCity())
                .teamName(team.getTeamName())
                .id(team.getId())
                .build();
    }
}
