package com.myapp.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordGeneratorTest {

    private String password;

    @Before
    public void generatePassword(){
        password = PasswordGenerator.generatePassword();
    }

    @Test
    public void should_return_password_with_correct_security_level(){
        Assert.assertTrue(UserValidator.validatePassword(password));
    }
}
