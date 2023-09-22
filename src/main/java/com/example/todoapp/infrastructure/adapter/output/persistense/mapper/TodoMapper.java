package com.example.todoapp.infrastructure.adapter.output.persistense.mapper;

import com.example.todoapp.infrastructure.adapter.output.persistense.entity.TodoEntity;
import com.example.todoapp.domain.model.Todo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class TodoMapper {

    private final ModelMapper modelMapper;

    public Todo toModel(TodoEntity todoEntity) {
        return modelMapper.map(todoEntity, Todo.class);
    }

    public TodoEntity toEntity(Todo todo) {
        return modelMapper.map(todo, TodoEntity.class);
    }
}
