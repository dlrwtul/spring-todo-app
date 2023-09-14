package com.example.todoapp.service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.dto.TodoCreate;
import com.example.todoapp.dto.TodoUpdate;
import com.example.todoapp.exception.NotFoundException;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> list() {
        return repository.findAll();
    }

    public Todo getOne(long id) {
        Optional<Todo> opTodo = repository.findById(id);
        if (!opTodo.isPresent()) {
            throw new NotFoundException("Todo not found");
        }
        
        return opTodo.get();
    }

    public Todo create(TodoCreate todoCreate) {
        Todo newTodo = repository.save(new Todo(todoCreate.getTitle()));
        return newTodo;
    }

    public Todo update(long id ,TodoUpdate todoUpdate) {
        Optional<Todo> opTodo = repository.findById(id);
        if (!opTodo.isPresent()) {
            throw new NotFoundException("Todo not found");
        }
        todoUpdate.setId(id);
        Todo todo = new Todo(todoUpdate.getId(),todoUpdate.getTitle(), todoUpdate.isDone());
        return repository.save(todo);
    }

    public void remove(long id) {
        boolean exist = repository.existsById(id);
        if (!exist) {
            throw new NotFoundException("Todo not found");
        }
        repository.deleteById(id);
    }
}
