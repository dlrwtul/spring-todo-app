package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.todoapp.dto.TodoCreate;
import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;

@Controller(value = "")
public class TodoController {
    
    @Autowired
    private TodoService service;

    @GetMapping()
    public String get(Model model) {
        List<Todo> todos = service.list();
        model.addAttribute("todo",new TodoCreate());
        model.addAttribute("todos",todos);

        return "todos";
    }

    @PostMapping(name = "")
    public RedirectView create(@ModelAttribute TodoCreate todo, Model model) {
        System.out.println(todo.getTitle());
        model.addAttribute("todo", todo);
        service.create(todo);
        return new RedirectView("/");
    }


}
