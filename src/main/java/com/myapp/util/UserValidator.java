package com.myapp.util;


import com.myapp.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    public static boolean validateUserName(String userName, UserService userService) {

        return (userName.length() < 3) || (userService.getUserByUserName(userName) != null) ? false : true;
    }

    public static boolean validatePassword(String password) {

        String regex = "(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return (matcher.lookingAt()) && (password.length() >= 8) ? true : false;
    }
}
