package com.teste.tcc.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        if(userRepository != null) {
            return userRepository.save(user);
        }
        return null;
    }

    public List<User> getAllUsers() {
        return Streamable.of(userRepository.findAll())
                .toList();
    }
}
