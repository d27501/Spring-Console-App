package com.myapp.service;

import com.myapp.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUserByUserName(String userName);
    void changeEmailAddress(String email, Integer id);
    void changePhoneNumber(String phoneNumber, Integer id);
    List<User> getAllUsers();
}
