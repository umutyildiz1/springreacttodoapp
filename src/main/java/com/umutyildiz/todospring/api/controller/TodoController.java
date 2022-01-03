package com.umutyildiz.todospring.api.controller;

import com.umutyildiz.todospring.business.abstracts.TodoService;
import com.umutyildiz.todospring.entities.concretes.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/todos/")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @PostMapping("createTodo")
    public void createTodo(@Valid @RequestBody Todo todo){
        todoService.createTodo(todo);
    }

    @DeleteMapping("deleteTodo")
    public ResponseEntity<String> deleteTodo(@RequestParam int id){
        return todoService.deleteTodo(id);

    }

    @PatchMapping("updateTodo")
    public void updateTodo(@RequestParam int todoId,@RequestParam String text){
        todoService.updateTodo(todoId,text);
    }

    @GetMapping("GetAllTodosByUserId")
    public ResponseEntity<List<Todo>> GetAllTodosByUserId(@RequestParam int userId){
        return todoService.GetAllTodosByUserId(userId);
    }
}
