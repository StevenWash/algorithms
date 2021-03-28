/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入描述: 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述: 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入  +2147483647
 *      1a33
 *
 * 输出  2147483647
 *      0
 *
 * @author huaxin
 * @create 2018/03/13 09:13
 */
public class StrToInt {

    public static int StrToInt(String str) {
        int flag = 0;
        int result = 0;
        int base = 1;

        if (str.length() <= 0) {
            return 0;
        }

        char c = str.charAt(0);
        if (c == '+') {
            flag = 0;
            str = str.substring(1);
        } else if (c == '-') {
            flag = 1;
            str = str.substring(1);
        }

        while (str.length() > 0 && str.charAt(0) == '0') {
            str = str.substring(1);
        }

        if (str.length() == 0) {
            return 0;
        }

        char[] strs = str.toCharArray();

        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i] < 48 || strs[i] >57) {
                return 0;
            }
            for (int j = 0; j < strs.length - i -1; j++) {
                base *= 10;
            }
            result += (strs[i] - 48) * base;
            base = 1;
        }

        if (flag == 1) {
            result = 0 - result;
        }

        return result;

    }

    public static void main(String[] args) {
        String str = "+0";
        System.out.println(StrToInt(str));
    }

}
