package com.teste.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.teste.tcc.model.user.UserDao;
import com.teste.tcc.model.user.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/user/save")
    public User save(@RequestBody User user) {
        return userDao.save(user);
    }

    @GetMapping("/user/get-all")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}