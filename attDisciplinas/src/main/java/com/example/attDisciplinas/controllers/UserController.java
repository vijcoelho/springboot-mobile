package com.example.attDisciplinas.controllers;

import com.example.attDisciplinas.model.usermodel.UserDao;
import com.example.attDisciplinas.model.usermodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/user/save")
    public User save(@RequestBody User user) {
        return userDao.save(user);
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> authUser(@RequestBody User user) {
        User authUser = userDao.authUser(user.getEmail(), user.getPassword());
        if (authUser != null) {
            String responde = "You're authenticated";
            return ResponseEntity.ok(responde);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    @GetMapping("/user/current")
    public User getCurrentUser() {
        return userDao.getCurrentUser();
    }
}
