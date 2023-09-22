package com.example.todoapp.infrastructure.adapter.input.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TodoCreate {

    @NotBlank(message = "Titre obligatoire")
    @NotNull(message = "Veuillez saisir un titre")
    private String title;

}
