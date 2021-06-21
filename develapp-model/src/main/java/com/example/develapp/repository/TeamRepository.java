package com.example.develapp.repository;

import com.example.develapp.jpa.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>, JpaSpecificationExecutor<Team> {

    List<Team> findTeamByTeamName(String teamName);

    List<Team> findTeamByCity(String city);

}
