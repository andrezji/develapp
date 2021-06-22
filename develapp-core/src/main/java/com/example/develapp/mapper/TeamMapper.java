package com.example.develapp.mapper;

import com.example.develapp.jpa.Team;
import com.example.develapp.model.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PersonMapper.class})
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamDto toDto(Team team);


}
