package com.example.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.dto.TodoCreate;
import com.example.todoapp.dto.TodoUpdate;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> list() {
        return repository.findAll();
    }

    public Optional<Todo> getOne(long id) {
        return repository.findById(id);
    }

    public Todo create(TodoCreate todoCreate) {
        Todo newTodo = repository.save(new Todo(todoCreate.getTitle()));
        return newTodo;
    }

    public void update(TodoUpdate todoUpdate) {
        Optional<Todo> opTodo = repository.findById(todoUpdate.getId());
        if (opTodo.isPresent()) {
            Todo todo = new Todo(todoUpdate.getTitle(), todoUpdate.isDone());
            repository.save(todo);
        }
    }

    public void remove(long id) {
        boolean exist = repository.existsById(id);
        
        if (exist) {
            repository.deleteById(id);
        }
    }
}
