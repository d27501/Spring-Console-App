package com.myapp.util;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordGenerator {

    public static String generatePassword() {

        return RandomStringUtils.random(2, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                + RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyz")
                + RandomStringUtils.random(2, "0123456789")
                + RandomStringUtils.random(1,"@#$%^&+=");
    }
}
