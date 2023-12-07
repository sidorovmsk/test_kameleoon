package com.example.test_kameleoon.services;

import com.example.test_kameleoon.models.User;
import com.example.test_kameleoon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Логика создания пользователя
        return userRepository.save(user);
    }

    public User getUserById(int userId) {
        // Логика получения пользователя по ID
        return userRepository.findById(userId).orElse(null);
    }


}
