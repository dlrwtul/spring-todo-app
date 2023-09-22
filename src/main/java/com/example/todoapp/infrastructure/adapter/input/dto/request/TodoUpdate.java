package com.example.todoapp.infrastructure.adapter.input.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoUpdate {

    private Long id;

    @NotBlank(message = "Titre obligatoire")
    @NotNull(message = "Veuillez saisir un titre")
    private String title;

    @NotNull(message = "Champs requis")
    private boolean isDone;
}
