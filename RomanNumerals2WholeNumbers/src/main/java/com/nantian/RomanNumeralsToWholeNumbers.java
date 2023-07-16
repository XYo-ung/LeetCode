package com.nantian;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToWholeNumbers {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    private static int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        char[] chars = s.toCharArray();
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += getInt(chars[i]);
        }
        return total;
    }

    private static Integer getInt(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }

}