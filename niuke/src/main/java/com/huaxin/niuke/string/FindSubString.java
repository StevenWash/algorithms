/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.string;

/**
 * 找子串的方法，分别使用了简单的暴力查找的方法和KMP算法
 *
 * @author huaxin
 */
public class FindSubString {

    /**
     * 暴力匹配的方法1,时间复杂度O((M-N)N)
     * @param str
     * @param patter
     * @return
     */
    public static int indexSubString1(String str, String patter){
        int len1 = str.length();
        int len2 = patter.length();

        for (int i = 0; i <= len1-len2; i++) {
            int j;
            for (j= 0; j< len2; j++) {
                if (str.charAt(i+j) != patter.charAt(j)) {
                    break;
                }
            }
            if (j == len2) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 暴力查找的方法2，时间复杂度：O(MN)
     * @param str
     * @param patter
     * @return
     */
    public static int indexSubString2(String str, String patter) {
        int len1 = str.length();
        int len2 = patter.length();
        int i = 0, j=0;
        /*
          记录主串中开始匹配的位置
         */
        int k = 0;

        while(i<len1 && j< len2) {
            if (str.charAt(i) == patter.charAt(j)){
                j++;i++;
            } else {
                j = 0;k++;i = k;
            }
        }
        if (j == len2) {
            return k;
        }
        return -1;
    }

    /**
     * 进行KMP算法的next数组的获取方法
     * @param str
     * @return
     */
    public static int[] getNext(String str) {
        int k , j = 0;
        int len = str.length();
        int []next = new int[len];
        next[0] = -1;
        k = next[0];

        while (j < len - 1) {
            if (k == -1 || str.charAt(k) == str.charAt(j)) {
                j++;
                k++;
                next[j] = k ;
            }else {
                k = next[k];
            }
        }

        return next;

    }

    /**
     * 进行KMP算法的next数组的优化之后的获取方法
     * @param str
     * @return
     */
    public static int[] getProNext(String str) {
        int k , j = 0;
        int len = str.length();
        int []next = new int[len];
        next[0] = -1;
        k = next[0];

        while (j < len - 1) {
            if (k == -1 || str.charAt(k) == str.charAt(j)) {
                j++;
                k++;

                if (str.charAt(k) == str.charAt(j)) {
                    next[j] = next[k];
                }else {
                    next[j] = k ;
                }
            }else {
                k = next[k];
            }
        }

        return next;
    }

    /**
     * 结合上面的next的获取函数，实现了kmp算法
     * @param str1
     * @param str2
     * @return
     */
    public static int KMP(String str1, String str2) {
        int i = 0, j = 0;
        int [] next = getProNext(str2);

        while (i < str1.length() && j < str2.length()) {
            if (j == -1 || str1.charAt(i) == str2.charAt(j)) {
                i++;j++;
            }else {
                j = next[j];
            }
        }

        if (j == str2.length()) {
            return i - j ;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "BBC ABCDAB ABCDABCDABDE";
        System.out.println(indexSubString2(str1, str2));

        String str4 = "BBC ABCDAB ABCDABCDABDE";
        String str5 = "ABCDABD";
        System.out.println(KMP(str4, str5));
    }
}
