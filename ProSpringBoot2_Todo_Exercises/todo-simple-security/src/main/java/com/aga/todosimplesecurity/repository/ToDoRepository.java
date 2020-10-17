package com.aga.todosimplesecurity.repository;

import com.aga.todosimplesecurity.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,String> {
}
