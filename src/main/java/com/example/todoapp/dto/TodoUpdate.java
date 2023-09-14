package com.example.todoapp.dto;

public class TodoUpdate {

    private long id;
    private String title;
    private boolean isDone;

    public TodoUpdate(long id, String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
