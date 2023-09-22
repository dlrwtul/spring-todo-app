package com.example.todoapp.infrastructure.adapter.input.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoGet {

    private Long id;
    private String title;
    private boolean isDone;
}
