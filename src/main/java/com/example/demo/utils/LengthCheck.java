package com.example.demo.utils;

public class LengthCheck {
    public static boolean check(String str) {
        return str.length() > 200;
    }

    public static boolean check(String str, Integer len) {
        return str.length() > len;
    }
}
