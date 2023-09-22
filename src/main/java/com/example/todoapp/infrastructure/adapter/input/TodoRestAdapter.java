package com.example.todoapp.infrastructure.adapter.input;

import java.util.List;

import com.example.todoapp.infrastructure.adapter.input.dto.request.TodoCreate;
import com.example.todoapp.infrastructure.adapter.input.dto.request.TodoUpdate;
import com.example.todoapp.infrastructure.adapter.input.dto.response.TodoGet;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.todoapp.domain.model.Todo;
import com.example.todoapp.domain.service.TodoService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoRestAdapter {

    private final TodoService service;

    private final ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<TodoGet>> get() {
        return ResponseEntity.ok(service.list().stream().map((todo) -> modelMapper.map(todo, TodoGet.class)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoGet> getOne(@PathVariable long id) {

        return ResponseEntity.ok(modelMapper.map(service.getOne(id),TodoGet.class));
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody TodoCreate todoCreate) {
        return new ResponseEntity<>(modelMapper.map(service.create(modelMapper.map(todoCreate,Todo.class)), TodoGet.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable long id, @Valid @RequestBody TodoUpdate todoUpdate) {
        todoUpdate.setId(id);
        return new ResponseEntity<>(service.update(modelMapper.map(todoUpdate, Todo.class)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.remove(id);
        return ResponseEntity.accepted().body("Todo deleted");
    }

}
