package com.example.todoapp.infrastructure.adapter.output.persistense;

import com.example.todoapp.application.port.output.TodoPersistencePort;
import com.example.todoapp.infrastructure.adapter.output.persistense.entity.TodoEntity;
import com.example.todoapp.infrastructure.adapter.output.persistense.mapper.TodoMapper;
import com.example.todoapp.infrastructure.adapter.output.persistense.repository.TodoRepository;
import com.example.todoapp.domain.model.Todo;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TodoPersistenceAdapter implements TodoPersistencePort {

    private final TodoMapper mapper;
    private final TodoRepository todoRepository;
    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll().stream().map((mapper::toModel)).collect(Collectors.toList());
    }

    @Override
    public Todo save(Todo todo) {
        return mapper.toModel(todoRepository.save(mapper.toEntity(todo)));
    }

    @Override
    public Optional<Todo> getById(Long id) {
        Optional<TodoEntity> optionalTodoEntity = todoRepository.findById(id);

        return optionalTodoEntity.map(mapper::toModel);

    }

    @Override
    public void remove(Long id) {
        todoRepository.deleteById(id);
    }
}
