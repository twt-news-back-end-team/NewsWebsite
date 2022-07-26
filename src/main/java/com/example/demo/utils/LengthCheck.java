package com.example.demo.utils;

public class LengthCheck {
    public static boolean check(String str) {
        return str.length() > 200;
    }

    public static boolean check(Integer len, String str) {
        return str.length() > len;
    }

    public static boolean check(String ... str) {
        for (String i : str) {
            if (check(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean check(Integer len, String ... str) {
        for (String i : str) {
            if (check(len, i)) {
                return true;
            }
        }
        return false;
    }
}
