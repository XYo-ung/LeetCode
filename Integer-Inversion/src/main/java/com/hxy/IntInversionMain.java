package com.hxy;

public class IntInversionMain {
    public static void main(String[] args) {
        int reverse = reverse(1563847412);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        int result;
        char[] chars = beforeInversion(x);
        if (chars.length > 10){
            return  0;
        }else if (chars.length == 10){
            if (chars[chars.length - 1] >= '3'){
                return 0;
            }
        }
        int i = 0, j = chars.length - 1;
        while (i != j && i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        try {
            String s = String.valueOf(chars);
            result = Integer.parseInt(s);
        }catch (Exception e) {
            return 0;
        }
        if (x < 0) {
            result = (-result);
        }
        return result;
    }

    private static char[] beforeInversion(int x) {
        String s = String.valueOf(x);
        if (s.charAt(0) == '-'){
            s = s.substring(1, s.length());
        }
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '0'){
                s = s.substring(0, i);
            }else {
                break;
            }
        }
        return s.toCharArray();
    }

}