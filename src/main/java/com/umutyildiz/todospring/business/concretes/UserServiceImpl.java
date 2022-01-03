package com.umutyildiz.todospring.business.concretes;

import com.umutyildiz.todospring.business.abstracts.UserService;
import com.umutyildiz.todospring.dataAccess.abstracts.UserDao;
import com.umutyildiz.todospring.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void createUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

}
