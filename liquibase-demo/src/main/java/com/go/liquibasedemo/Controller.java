package com.go.liquibasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired(required = true)
    private PersonRepository personRepository;

    @PostMapping("/person")
    public String createPerson(@RequestParam String name){
        personRepository.save(new Person(name, "6.9"));
        return personRepository.findByName(name)+ " Saved successfully";
    }

    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return (List<Person>)personRepository.findAll();
    }

}
