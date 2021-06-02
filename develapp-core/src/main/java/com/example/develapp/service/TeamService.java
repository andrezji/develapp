package com.example.develapp.service;




import com.example.develapp.jpa.Team;
import com.example.develapp.model.TeamDto;
import com.example.develapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<TeamDto> getTeamsPageFilter(String phrase, Pageable pageable) {
        return teamRepository.findAllByCityContainingIgnoreCaseOrCountryContainingIgnoreCaseOrTeamNameContainingIgnoreCase(phrase, phrase, phrase, pageable)
                             .map(this::mapper);
    }

}
