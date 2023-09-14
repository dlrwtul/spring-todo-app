package com.example.todoapp.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TodoCreate {

    @NotBlank(message = "Titre obligatoire")
    @NotNull(message = "Veuillez saisir un titre")
    private String title;

    public TodoCreate() {
    }

    public TodoCreate(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
