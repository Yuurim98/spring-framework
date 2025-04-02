package com.example.myfirstwebapp.todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(
            new Todo(++todosCount, "홍길동", "Spring", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "홍길동", "JPA", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "홍길동", "AWS", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream()
            .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
            .toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, false);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream()
            .filter(todo -> todo.getId() == id)
            .findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
