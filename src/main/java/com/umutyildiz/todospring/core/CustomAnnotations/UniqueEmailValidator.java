package com.umutyildiz.todospring.core.CustomAnnotations;
import com.umutyildiz.todospring.dataAccess.abstracts.UserDao;
import com.umutyildiz.todospring.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String>{

    @Autowired
    private UserDao userDao;

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        User user = userDao.getByEmail(s);
        if(user != null){
            return false;
        }
        return true;
    }
}
