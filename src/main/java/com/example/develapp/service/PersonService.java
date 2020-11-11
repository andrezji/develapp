package com.example.develapp.service;

import com.example.develapp.model.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("app")
@Component
public class PersonService {


    private List<Person> persons = new ArrayList<>();


    public List<Person> getPersons() {
        return persons;
    }


    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

}
