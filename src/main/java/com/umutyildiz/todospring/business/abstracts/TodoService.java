package com.umutyildiz.todospring.business.abstracts;

import com.umutyildiz.todospring.entities.concretes.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {
    void createTodo(Todo todo);
    ResponseEntity<String> deleteTodo(int id);
    void updateTodo(int todoId,String text);
    ResponseEntity<List<Todo>> GetAllTodosByUserId(int id);
}
