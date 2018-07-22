package com.myapp.service.impl;

import com.myapp.domain.User;
import com.myapp.domain.repository.UserRepository;
import com.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    public void changeEmailAddress(String email, Integer id) {
        userRepository.changeEmailAddress(email, id);
    }

    public void changePhoneNumber(String phoneNumber, Integer id) {
        userRepository.changePhoneNumber(phoneNumber, id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
