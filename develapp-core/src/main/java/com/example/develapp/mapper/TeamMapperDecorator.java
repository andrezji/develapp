package com.example.develapp.mapper;

import com.example.develapp.jpa.Team;
import com.example.develapp.model.PersonDto;
import com.example.develapp.model.TeamDto;

import java.util.ArrayList;
import java.util.List;

public class TeamMapperDecorator implements TeamMapper{

    private final TeamMapper teamMapper;

    public TeamMapperDecorator(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @Override
    public TeamDto toDto(Team team) {
        TeamDto teamDto = teamMapper.toDto(team);
        List<PersonDto> personDtoList = new ArrayList<>();
        team.getPersons().forEach(person -> personDtoList.add(PersonMapper.INSTANCE.toDto(person)));
        teamDto.setPersons(personDtoList);
        return teamDto;
    }
}
