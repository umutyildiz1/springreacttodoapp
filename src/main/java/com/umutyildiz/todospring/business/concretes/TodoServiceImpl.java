package com.umutyildiz.todospring.business.concretes;

import com.umutyildiz.todospring.business.abstracts.TodoService;
import com.umutyildiz.todospring.dataAccess.abstracts.TodoDao;
import com.umutyildiz.todospring.entities.concretes.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Override
    public void createTodo(Todo todo) {
        todoDao.save(todo);
        ResponseEntity.ok("todo eklendi");
    }

    @Override
    public ResponseEntity<String> deleteTodo(int id) {
        todoDao.deleteById(id);
        return ResponseEntity.ok("Id:" + id +" is deleted");
    }

    @Override
    public void updateTodo(int todoId, String text) {
        Todo temp = todoDao.getById(todoId);
        temp.setText(text);
        todoDao.save(temp);
    }

    @Override
    public ResponseEntity<List<Todo>> GetAllTodosByUserId(int userId) {
        return ResponseEntity.ok(todoDao.GetAllTodosByUserId(userId));
    }
}
