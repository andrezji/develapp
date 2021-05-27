package com.example.develapp.rest;

import com.example.develapp.model.TeamDto;
import com.example.develapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerService {

    private final TeamService teamService;

    @Autowired
    public RestControllerService( TeamService teamService) {
        this.teamService = teamService;
    }


//    @GetMapping("/teamsList")
//    public List<TeamDto> getTeams() {
//        return teamService.getTeams();
//    }
//
//    @GetMapping("/teams")
//    public Page<Team> getTeams(@RequestParam String city) {
//        return teamService.getByCity(city);
//    }

    @GetMapping("/teamsPage")
    public Page<TeamDto> getTeamsPage(
//            @PageableDefault(page = 0, size = 5)
//            @SortDefault.SortDefaults({
//                    @SortDefault(sort = "id", direction = Sort.Direction.ASC)
//            })
                    Pageable pageable, @RequestParam(required = false) String phrase) {
        if (phrase == null) {
            return teamService.getTeamsPage(pageable);
        }
        return teamService.getTeamsPageFilter(phrase, pageable);
    }

}
