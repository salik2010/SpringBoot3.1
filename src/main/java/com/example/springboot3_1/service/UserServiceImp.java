package com.example.springboot3_1.service;

import com.example.springboot3_1.entity.User;
import com.example.springboot3_1.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserJpaRepository userJpaRepository;

    public UserServiceImp(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }
    public List<User> getAll(){
        return userJpaRepository.findAll();
    }
    public void newUser(User user){
        userJpaRepository.save(user);
    }
    public void deleteUser(Long id){
        userJpaRepository.deleteById(id);
    }
    public User editUser(User user){
        return userJpaRepository.save(user);
    }
    public User getById(Long id){
        return userJpaRepository.getById(id);
    }
}
