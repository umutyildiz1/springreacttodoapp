package com.umutyildiz.todospring.business.concretes;

import com.umutyildiz.todospring.business.abstracts.AuthService;
import com.umutyildiz.todospring.dataAccess.abstracts.UserDao;
import com.umutyildiz.todospring.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<?> handleAuth(User user) {
        return ResponseEntity.ok(user);

    }
}
