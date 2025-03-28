package com.example.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "test-name", "Spring", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "test-name", "JPA", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(3, "test-name", "AWS", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
