package com.young;

public class Main {
    public static void main(String[] args) {
        System.out.println();
    }

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < 13) {
            while(num >= nums[i]) {
                sb.append(romans[i]);
                num -= nums[i];
            }
            i++;
        }

        return sb.toString();
    }

}