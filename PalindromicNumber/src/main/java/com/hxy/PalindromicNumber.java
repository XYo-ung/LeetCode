package com.hxy;

public class PalindromicNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }else if (number < 10){
            return true;
        }
        String numberStr = String.valueOf(number);
        int i = 0, j = numberStr.length() - 1;
        char[] chars = numberStr.toCharArray();
        while (i != j && i < j){
            if (chars[i] == chars[j]){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}