package com.example.todoapp.application.port.input;

import com.example.todoapp.domain.model.Todo;

import java.util.List;

public interface TodoUseCase {
    List<Todo> list();

    Todo create(Todo todo);

    Todo getOne(Long id);

    Todo update(Todo todo);

    void delete(Long id);
}
