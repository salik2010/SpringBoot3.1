package com.example.springboot3_1.service;

import com.example.springboot3_1.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public void newUser(User user);
    public void deleteUser(Long id);
    public User editUser(User user);
    public User getById(Long id);
}
