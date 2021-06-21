package com.example.develapp.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamFilter {
    
    private String name;
    private String city;
    private String country;
    
}
