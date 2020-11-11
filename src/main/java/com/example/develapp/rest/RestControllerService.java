package com.example.develapp.rest;

import com.example.develapp.model.Person;
import com.example.develapp.model.TeamDto;
import com.example.develapp.service.PersonService;
import com.example.develapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RestControllerService {

    private final PersonService personService;
    private final TeamService teamService;

    @Autowired
    public RestControllerService(PersonService personService, TeamService teamService) {
        this.personService = personService;
        this.teamService = teamService;
    }

    @GetMapping("/hello")
    public List<Person> sayHello(@RequestParam(value = "myName", defaultValue = "World") String name,
                                 HttpServletRequest request) {
//        String header = request.getHeader("User-Agent");
//        String remoteAddr = request.getRemoteAddr();
//        return String.format("Hello " + example);
        return personService.getPersons();
    }

    @GetMapping("/teams")
    public List<TeamDto> getTeams() {
        return teamService.getTeams();
    }

}
