package com.example.develapp.rest;

import com.example.develapp.model.TeamDto;
import com.example.develapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RestControllerService {

    private final TeamService teamService;

    @Autowired
    public RestControllerService( TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teamsPage")
    public Page<TeamDto> getTeamsPage(Pageable pageable, @RequestParam Map<String, Object> map) {
        return teamService.getTeamsByFilters(map, pageable);
    }

    @PostMapping("/add")
    public void createTeam(@RequestBody TeamDto teamDto) {
        teamService.create(teamDto);
    }

}
