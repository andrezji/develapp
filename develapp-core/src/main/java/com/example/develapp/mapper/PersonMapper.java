package com.example.develapp.mapper;

import com.example.develapp.jpa.Person;
import com.example.develapp.model.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(target = "teamId", source = "team.id")
    })
    PersonDto toDto(Person person);

}
