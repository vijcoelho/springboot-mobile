package com.daroca.ecommerce.controller;

import com.daroca.ecommerce.model.User;
import com.daroca.ecommerce.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("home")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user/get-all")
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
        return userDao.saveUser(user);
    }
}
