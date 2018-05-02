/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.string;

/**
 * Description:
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，
 * 请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 *
 * 测试样例： "abc",3,"bca",3
 *
 * 返回：true
 *
 * @author huaxin
 * @create 2018/03/12 20:27
 */
public class Transform {

    public static boolean chkTransform(String A, int lena, String B, int lenb) {
        if (lena != lenb) {
            return false;
        }

        int [] countA = new int[65536];
        int [] countB = new int[65536];

        for (int i = 0; i < lena; i++) {
            countA[A.charAt(i)]++;
            countB[B.charAt(i)]++;
        }

        for (int i = 0; i < countA.length; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String A = "abc";
        String B = "bda";
        System.out.println(chkTransform(A,3,B,3));
    }

}
