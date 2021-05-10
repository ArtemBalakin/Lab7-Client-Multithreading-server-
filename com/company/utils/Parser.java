package com.company.utils;

public class Parser {
    public static boolean tryParseInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static boolean tryParseFloat(String string) {
        try {
            Float.parseFloat(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static boolean tryParseLong(String string) {
        try {
            Long.parseLong(string);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}
