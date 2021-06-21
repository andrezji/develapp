package com.example.develapp.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private Long teamId;
    private String firstName;
    private String lastName;

}
