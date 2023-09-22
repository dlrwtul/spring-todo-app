package com.example.todoapp.application.port.output;

import com.example.todoapp.domain.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoPersistencePort {

    List<Todo> getAll() ;

    Todo save(Todo todo) ;

    Optional<Todo> getById(Long id) ;

    void remove(Long id) ;
}
