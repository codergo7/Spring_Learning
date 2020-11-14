package com.go.liquibasedemo;


import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT name FROM Person p WHERE p.name LIKE %:personName%")
    String findByName(String personName);
}
