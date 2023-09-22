package com.example.todoapp.infrastructure.adapter.output.persistense.repository;

import com.example.todoapp.infrastructure.adapter.output.persistense.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
