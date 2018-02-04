/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.easy;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {

        if (x<0||(x!=0&&x%10==0)) {
            return false;
        } else {
            int len;
            int temp_integer;

            //先判断当前数字是正还是负
            if ( x>= 0) {
                len = (x + "").length();
            } else {
                return false;
            }

            temp_integer = x;
            StringBuilder str_x = new StringBuilder();
            for (int i = 0; i < len; i++) {
                str_x.append(temp_integer % 10);
                temp_integer = temp_integer / 10;
            }
            try {
                temp_integer = Integer.parseInt(str_x.toString());
                return x == temp_integer;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
