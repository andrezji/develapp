package com.example.develapp.service;


import com.example.develapp.jpa.Team;
import com.example.develapp.mapper.TeamMapper;
import com.example.develapp.model.TeamDto;
import com.example.develapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamQueryService teamQueryService;


    @Autowired
    public TeamService(TeamRepository teamRepository,
                       TeamQueryService teamQueryService
                        ) {
        this.teamRepository = teamRepository;
        this.teamQueryService = teamQueryService;
    }

    public Page<TeamDto> getTeamsByFilters(Map<String, String> params, Pageable pageable) {
        return teamQueryService.getPageFilter(params, pageable, Team.class).map(TeamMapper.INSTANCE::toDto);
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

}
