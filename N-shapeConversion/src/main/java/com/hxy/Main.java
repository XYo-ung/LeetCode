package com.hxy;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

    }

    public String convert(String s, int n) {
        int length = s.length();
        int column;
        int remainder = length % (2 * n - 2) == 0；
        if (remainder == 0){
            column = (length / (2 * n - 2)) * (n -1);
        }else {
            column = (length / (2 * n - 2)) + 1 ;
        }
    }
}