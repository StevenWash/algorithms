/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.easy;

/**
 * Description:
 *   Implement strStr().
 *   Return the index of the first occurrence of needle in haystack,
 *   or -1 if needle is not part of haystack.
 *
 * Example 1:
 *   Input: haystack = "hello", needle = "ll"
 *   Output: 2
 *
 * Example 2:
 *   Input: haystack = "aaaaa", needle = "bba"
 *   Output: -1
 */
public class ImplementstrStr {


    public static int strStr1(String haystack, String needle) {

        return 0;
    }

    /**
     * 使用Java的内置API的功能
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "dsll";
        System.out.println(strStr1(str1,str2));
    }
}
