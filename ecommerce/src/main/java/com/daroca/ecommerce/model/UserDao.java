package com.daroca.ecommerce.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao {

    private User authUser;

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return Streamable.of(userRepository.findAll()).toList();
    }

    public User authUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            authUser = user;
            return user;
        } else {
            return null;
        }
    }

    public User getCurrentUser() {
        return authUser;
    }
}
