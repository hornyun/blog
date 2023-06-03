package com.hornyun.blog.util;

import org.apache.commons.codec.binary.Hex;

import java.security.SecureRandom;

/**
 * @author hornyun
 */
public class PasswordUtil {


    private static final int SALT_SIZE = 8;


    private PasswordUtil(){
    }

    public static String generateSalt() {
        byte[] bytes = new byte[SALT_SIZE];
        new SecureRandom().nextBytes(bytes);
        return Hex.encodeHexString(bytes);
    }
}
