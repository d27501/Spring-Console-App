package com.myapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User user;

    @Before
    public void setup() {
        user = new User();
    }

    @Test
    public void user_should_store_correct_data() {
        String username = "admin";
        String password = "Pass123$";
        String email = "email@onet.pl";
        String phoneNumber = "123456789";

        user.setUserName(username);
        user.setPassword(password);
        user.setUserEmail(email);
        user.setPhoneNumber(phoneNumber);

        Assert.assertEquals(user.getUserName(), username);
        Assert.assertEquals(user.getPassword(), password);
        Assert.assertEquals(user.getUserEmail(), email);
        Assert.assertEquals(user.getPhoneNumber(), phoneNumber);
    }
}
