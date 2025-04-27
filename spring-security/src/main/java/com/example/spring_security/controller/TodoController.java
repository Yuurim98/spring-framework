package com.example.spring_security.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private static final List<Todo> TODO_LIST = List.of(new Todo("test", "맛있는 거 먹기"),
            new Todo("test", "영화"));
    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODO_LIST;
    }

    @PostMapping("/users/{username}/todos")
    public void createTodo(@PathVariable String username, @RequestBody Todo todo) {

    }

}

record Todo(String username, String description) {}
