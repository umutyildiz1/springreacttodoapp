package com.umutyildiz.todospring.api.controller;

import com.umutyildiz.todospring.business.abstracts.UserService;
import com.umutyildiz.todospring.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok("Kullanıcı eklendi");
    }



}
