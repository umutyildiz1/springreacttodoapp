package com.umutyildiz.todospring.dataAccess.abstracts;

import com.umutyildiz.todospring.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}
