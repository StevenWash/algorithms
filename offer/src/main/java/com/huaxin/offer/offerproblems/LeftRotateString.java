/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author huaxin
 * @create 2018/03/13 09:02
 */
public class LeftRotateString {

    public static String LeftRotateString(String str,int n) {
        if (n <= 0) {
            return str;
        }

        if (str.length() <= 0) {
            return "";
        }

        String str1 = reverse(str.substring(0, n));
        String str2 = reverse(str.substring(n, str.length()));
        return reverse(str1+str2);
    }

    public static String reverse(String str) {
        char temp;
        char[] strs = str.toCharArray();
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        return new String(strs);
    }

    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(LeftRotateString(str, 1));
    }

}
