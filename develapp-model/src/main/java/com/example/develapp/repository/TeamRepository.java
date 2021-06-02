package com.example.develapp.repository;

import com.example.develapp.jpa.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {


    Page<Team> findAllByCityContainingIgnoreCaseOrCountryContainingIgnoreCaseOrTeamNameContainingIgnoreCase(String city,String country, String teamName, Pageable pageable);
}
