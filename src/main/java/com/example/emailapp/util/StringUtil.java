package com.example.emailapp.util;

public class StringUtil {
    public StringUtil() {
    }

    public static boolean isValid(String data) {
        return null != data && data.trim().length() > 0;
    }
}