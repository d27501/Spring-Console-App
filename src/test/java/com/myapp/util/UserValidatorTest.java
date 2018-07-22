package com.myapp.util;

import org.junit.Assert;
import org.junit.Test;

public class UserValidatorTest {

    @Test
    public void validatePassword_should_return_true_if_password_is_ok(){
        Assert.assertTrue(UserValidator.validatePassword("Pass123$"));
        Assert.assertTrue(UserValidator.validatePassword("QwErTy'8&"));
        Assert.assertTrue(UserValidator.validatePassword("aaaaaaaaaaaaaaaa3#B"));
    }
    @Test
    public void validatePassword_should_return_false_if_password_is_not_ok(){
        Assert.assertEquals(UserValidator.validatePassword("Password123"), false);
        Assert.assertEquals(UserValidator.validatePassword("12345678"), false);
        Assert.assertEquals(UserValidator.validatePassword("MyPass##$"), false);
        Assert.assertEquals(UserValidator.validatePassword("Pass1@"), false);
    }

    @Test
    public void validatePassword_should_return_false_in_case_of_empty_password(){
        Assert.assertFalse(UserValidator.validatePassword(""));
    }
}
