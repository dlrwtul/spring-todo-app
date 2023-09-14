package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.todoapp.dto.*;
import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping()
    public ResponseEntity<List<Todo>> get() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getOne(@PathVariable long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody TodoCreate todoCreate) {
        return new ResponseEntity<>(service.create(todoCreate), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable long id, @Valid @RequestBody TodoUpdate todoUpdate) {
        return new ResponseEntity<>(service.update(id, todoUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            service.remove(id);
            return ResponseEntity.accepted().body("Todo deleted");
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
