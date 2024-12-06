package com.example.eduardo.controller;

import com.example.eduardo.model.User;
import com.example.eduardo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PutMapping("/update")
    public User update(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String new_email = request.get("new_email");
        User user = userRepository.findByEmail(email);
        user.setEmail(new_email);
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "USER IS NULL";
        }
        if (user.getPassword().equals(password)){
            return ("OK");

        }
        return ("Email/Senha errado.");

    }
}
