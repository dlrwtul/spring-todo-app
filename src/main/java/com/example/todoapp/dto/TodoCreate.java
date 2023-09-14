package com.example.todoapp.dto;

public class TodoCreate {
    
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
