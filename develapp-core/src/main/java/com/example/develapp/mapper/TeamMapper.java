package com.example.develapp.mapper;

import com.example.develapp.jpa.Person;
import com.example.develapp.jpa.Team;
import com.example.develapp.model.PersonDto;
import com.example.develapp.model.TeamDto;

import java.util.ArrayList;
import java.util.List;

public class TeamMapper {

    public static TeamDto map(Team team) {
        return TeamDto.builder()
                      .city(team.getCity())
                      .teamName(team.getTeamName())
                      .country(team.getCountry())
                      .id(team.getId())
                      .personList(mapPersonList(team.getPersons()))
                      .build();
    }

    private static List<PersonDto> mapPersonList(List<Person> personList) {
        ArrayList<PersonDto> personDtoList = new ArrayList<>();
        personList.forEach(person -> personDtoList.add(PersonMapper.map(person)));
        return personDtoList;
    }

}
