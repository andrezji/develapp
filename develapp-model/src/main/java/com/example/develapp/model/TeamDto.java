package com.example.develapp.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

    private Long id;
    private String teamName;
    private String city;
    private String country;

}
