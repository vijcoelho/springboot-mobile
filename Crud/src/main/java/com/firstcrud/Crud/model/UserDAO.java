package com.firstcrud.Crud.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return Streamable.of(userRepository.findAll()).toList();
    }

    public User changeInformations(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
