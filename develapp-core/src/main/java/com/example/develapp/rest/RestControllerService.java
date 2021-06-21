package com.example.develapp.rest;

import com.example.develapp.model.TeamDto;
import com.example.develapp.request.TeamFilter;
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
    public Page<TeamDto> getTeamsPage(Pageable pageable, TeamFilter teamFilter) {
        return teamService.getTeamsPageFilter(teamFilter, pageable);
    }


    @GetMapping("/teamsTest")
    public Page<TeamDto> getTeamsPage(Pageable pageable, @RequestParam Map<String, String> map) {
//        return Page.empty();
        return teamService.getTeamsPageFilter(map, pageable);
    }
//    @GetMapping("/teams")
//    public Page<TeamDto> getTeams(Pageable pageable) {
//        return teamService.getReflectTeams(pageable);
//    }

    @PostMapping("/add")
    public void createTeam(@RequestBody TeamDto teamDto) {
        teamService.create(teamDto);
    }

}
