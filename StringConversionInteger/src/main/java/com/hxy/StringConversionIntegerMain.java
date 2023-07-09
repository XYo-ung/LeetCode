package com.hxy;

public class StringConversionIntegerMain {
    public static void main(String[] args) {
        int i = myAtoi("-21474836482");
        System.out.println(i);
    }

    public static int myAtoi(String s) {
        /** 去掉前置空格 */
        s = s.trim();
        int flag = 0;
        int i = 0;
        char[] chars = s.toCharArray();
        int result = 0;
        if (chars.length == 0){
            return 0;
        }
        if (chars[0] == '-'){
            flag = 1;
            i = 1;
        } else if (chars[0] == '+') {
            i = 1;
        } else if ('0' > chars[0] || chars[0] > '9') {
            return 0;
        }
        for (;i < chars.length; i++){
            if (result == 0 && chars[i] == '0'){
                continue;
            }
            if (result == 0 && i >= 1 && ('0' > chars[i] || chars[i] > '9')){
                break;
            }
            if ('0' <= chars[i] && chars[i] <= '9') {
                if (result > Integer.MAX_VALUE /10){
                    if (flag == 1){
                        result = Integer.MIN_VALUE;
                    }else {
                        result = Integer.MAX_VALUE;
                    }
                    break;
                }else if (result == Integer.MAX_VALUE /10){
                    if (flag == 1 && chars[i] <= '7'){
                        result = result * 10 + 7;
                    } else if (flag == 0 && chars[i] <= '7') {
                        result = result * 10 + Integer.parseInt(String.valueOf(chars[i]));
                    } else {
                        if (flag == 1){
                            result = Integer.MIN_VALUE;
                        }else {
                            result = Integer.MAX_VALUE;

                        }
                        return result;
                    }
                } else {
                    result = result * 10 + Integer.parseInt(String.valueOf(chars[i]));

                }
            }else if (result != 0) {
                break;
            }
        }
        if (flag == 1 && result != Integer.MIN_VALUE) {
            result = -(result);
        }
        return result;
    }
}