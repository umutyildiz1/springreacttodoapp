package com.umutyildiz.todospring.api.controller;

import com.umutyildiz.todospring.business.abstracts.AuthService;
import com.umutyildiz.todospring.core.CustomAnnotations.CurrentUser;
import com.umutyildiz.todospring.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("handle")
    public ResponseEntity<?> handleAuth(@CurrentUser User user){
        return authService.handleAuth(user);
    }
}
