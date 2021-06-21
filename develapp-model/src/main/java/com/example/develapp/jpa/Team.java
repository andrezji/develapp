package com.example.develapp.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "team", schema = "main")
public class Team {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "main.team_id_seq")
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Person> persons;
}


