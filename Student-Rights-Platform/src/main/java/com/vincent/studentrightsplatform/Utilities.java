package com.vincent.studentrightsplatform;

import java.util.Base64;
import java.util.Date;

public class Utilities {
    public static String getDateAndTime(long millisecond) {
        Date date = new Date(millisecond);
        return date.toString();
    }

    public static String base64Encrypt(byte[] file) {
        return Base64.getEncoder().encodeToString(file);
    }

    public static byte[] base64Decrypt(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
