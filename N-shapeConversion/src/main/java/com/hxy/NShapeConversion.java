package com.hxy;


public class NShapeConversion {
    public static void main(String[] args) {
        String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        String convert = convert(s, 4);
        System.out.println(convert);

    }

    public static String convert(String s, int n) {
        int length = s.length();
        if (n == 1 || n >= length) {
            return s;
        }
        int column = getColumnNum(length, n);
        char[][] resultArr = new char[n][column];
        int x = 0, y = 0;
        for (int i = 0 ; i < length; i++) {
            resultArr[y][x] = s.charAt(i);
            if (i % (2 * n - 2) < n - 1) {
                y++;
            }else {
                x++;
                y--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (char[] temp: resultArr){
            for (char temp2 : temp){
                if (temp2 != 0) {
                    result.append(temp2);
                }
            }
        }
        return result.toString();
    }

    public static int getColumnNum(int length, int n){
        int column = 1;
        int remainder = length % (2 * n - 2);
        if (remainder == 0){
            column = (length / (2 * n - 2)) * (n -1);
        }else if (remainder <= n){
            column = (length / (2 * n - 2)) * (n -1) + 1 ;
        }else if (remainder > n){
            column = (length / (2 * n - 2)) * (n -1) + 1 + remainder - n;
        }
        return column;
    }
}