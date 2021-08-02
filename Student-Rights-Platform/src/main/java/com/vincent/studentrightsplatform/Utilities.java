package com.vincent.studentrightsplatform;

import java.util.Date;

public class Utilities {
    public static String getDateAndTime(long millisecond) {
        Date date = new Date(millisecond);
        return date.toString();
    }
}
