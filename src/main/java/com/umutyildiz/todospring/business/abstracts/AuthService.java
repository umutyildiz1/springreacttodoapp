package com.umutyildiz.todospring.business.abstracts;

import com.umutyildiz.todospring.entities.concretes.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity handleAuth(User user);
}
