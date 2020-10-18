package com.aga.todosimplesecurity.repository;

import com.aga.todosimplesecurity.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

/*
Defining the interface that extends from the CrudRepository<T,ID> that has not only the
CRUD methods, but also the Spring Data REST, creates all the necessary REST APIs to
support the domain class.
 */
public interface ToDoRepository extends CrudRepository<ToDo,String> {
}
