package com.example.attDisciplinas.model.usermodel;

import com.example.attDisciplinas.model.usermodel.User;
import com.example.attDisciplinas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    private User user;

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User authUser(String email, String password) {
        User userAuthenticator = userRepository.findByEmail(email);
        if (userAuthenticator != null && userAuthenticator.getPassword().equals(password)) {
            user = userAuthenticator;
            return user;
        }
        return null;
    }

    public User getCurrentUser() {
        return user;
    }
}
