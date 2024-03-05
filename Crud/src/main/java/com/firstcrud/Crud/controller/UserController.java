package com.firstcrud.Crud.controller;

import com.firstcrud.Crud.model.User;
import com.firstcrud.Crud.model.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("user-getAll")
    public List<User> getAll() {
        return userDAO.getAllUsers();
    }

    @PostMapping("user-save")
    public User save(@RequestBody User user) {
        return userDAO.saveUser(user);
    }

    @PostMapping("user-delete")
    public void delete(@RequestBody User user) {
        userDAO.deleteUser(user);
    }
}
