package com.example.eduardoSozinho.controller;

import com.example.eduardoSozinho.model.User;
import com.example.eduardoSozinho.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping ("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/criar")
    public User createUser(@RequestBody User user)
    }
    @GetMapping("/getAll")
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Integer Id){
    }
    }

