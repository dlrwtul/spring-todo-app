package com.example.todoapp.infrastructure.adapter.config;

import com.example.todoapp.domain.service.TodoService;
import com.example.todoapp.infrastructure.adapter.output.persistense.TodoPersistenceAdapter;
import com.example.todoapp.infrastructure.adapter.output.persistense.mapper.TodoMapper;
import com.example.todoapp.infrastructure.adapter.output.persistense.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean TodoMapper todoMapper(ModelMapper modelMapper) {
        return new TodoMapper(modelMapper);
    }
    @Bean
    public TodoPersistenceAdapter todoPersistenceAdapter(TodoRepository todoRepository, TodoMapper todoMapper) {
        return  new TodoPersistenceAdapter(todoMapper, todoRepository);
    }

    @Bean
    public TodoService todoService(TodoPersistenceAdapter todoPersistenceAdapter) {
        return  new TodoService(todoPersistenceAdapter);
    }
}
