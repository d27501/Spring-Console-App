package com.myapp.util;

import org.junit.Assert;
import org.junit.Test;

public class PasswordEncryptorTest {

    @Test
    public void crypt_function_should_return_correct_hash_value() {
        Assert.assertEquals(PasswordEncryptor.crypt("Pass1234%"), "436998638f00c47de7252c3cc6df8fcf");
        Assert.assertEquals(PasswordEncryptor.crypt("qwerty$#1PASS"), "7da92db70edf7ea774f2cb57913aeafb");
    }

    @Test(expected = IllegalArgumentException.class)
    public void crypt_function_should_throw_exception_in_case_of_bad_argument(){
        PasswordEncryptor.crypt("");
        PasswordEncryptor.crypt(null);
    }
}
