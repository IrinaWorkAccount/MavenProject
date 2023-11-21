package org.example.service;

import org.example.dao.UserRepository;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user){
        if (userRepository != null) {
            userRepository.save(user);
        } else {
            throw new RuntimeException("UserRepository is null");         }
    }

    public List<User> getAll(){
        if (userRepository != null) {
            return userRepository.findAll();
        } else {
            throw new RuntimeException("UserRepository is null");
        }
    }
}
