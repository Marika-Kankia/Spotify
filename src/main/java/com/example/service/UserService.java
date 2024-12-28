package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);

    User saveUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User getUserById(Long userId);
}
