package com.example.todoapp.application.port.output;

import com.example.todoapp.model.Todo;

import java.util.List;

public interface TodoPersistence {

    List<Todo> getAll() ;

    Todo save(Todo todo) ;

    Todo getById(Long id) ;

    Todo edit(Todo todo) ;

    void remove(Long id) ;
}
