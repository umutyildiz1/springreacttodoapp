package com.umutyildiz.todospring.dataAccess.abstracts;

import com.umutyildiz.todospring.entities.concretes.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoDao extends JpaRepository<Todo,Integer> {
    void deleteById(int id);

    @Query("from Todo where user.userId=:userId")
    List<Todo> GetAllTodosByUserId(int userId);

}
