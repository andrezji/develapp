package com.example.develapp.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.develapp.jpa.Person;
import com.example.develapp.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonQuery implements GraphQLQueryResolver {

    private final PersonRepository personRepository;

    public PersonQuery(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
