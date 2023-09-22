package com.example.todoapp.infrastructure.adapter.output.persistense.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "isDone")
    private boolean isDone = false;
}
