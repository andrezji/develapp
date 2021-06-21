package com.example.develapp.mapper;

import com.example.develapp.jpa.Person;
import com.example.develapp.model.PersonDto;

public class PersonMapper {

    public static PersonDto map(Person person) {
        return PersonDto.builder()
                        .id(person.getId())
                        .firstName(person.getFirstName())
                        .lastName(person.getLastName())
                        .teamId(person.getTeam().getId())
                        .build();
    }
}
