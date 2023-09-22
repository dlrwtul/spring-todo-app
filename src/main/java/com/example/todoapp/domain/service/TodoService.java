package com.example.todoapp.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.todoapp.infrastructure.adapter.output.persistense.TodoPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import com.example.todoapp.domain.exception.NotFoundException;
import com.example.todoapp.domain.model.Todo;

@RequiredArgsConstructor
public class TodoService {

    private final TodoPersistenceAdapter todoPersistenceAdapter;

    public List<Todo> list() {
        return todoPersistenceAdapter.getAll();
    }

    public Todo getOne(long id) {
        return todoPersistenceAdapter.getById(id).orElseThrow(() -> new NotFoundException("Todo not found"));
    }

    public Todo create(Todo todo) {
        return todoPersistenceAdapter.save(todo);
    }

    public Todo update(Todo todo) {
        Optional<Todo> opTodo = todoPersistenceAdapter.getById(todo.getId());

        if (opTodo.isEmpty()) {
            throw new NotFoundException("Todo not found");
        }

        return todoPersistenceAdapter.save(todo);
    }

    public void remove(long id) {
        Optional<Todo> opTodo = todoPersistenceAdapter.getById(id);

        if (opTodo.isEmpty()) {
            throw new NotFoundException("Todo not found");
        }

        todoPersistenceAdapter.remove(id);
    }
}
