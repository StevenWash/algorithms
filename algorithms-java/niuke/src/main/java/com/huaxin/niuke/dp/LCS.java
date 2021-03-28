/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.dp;

/**
 * Description:
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 *
 * 测试样例： "1A2C3D4B56",10,"B1D23CA45B6A",12
 *
 * 返回：6
 *
 * @author huaxin
 * @create 2018/03/08 09:32
 */
public class LCS {

    public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n][m];

        int index = A.indexOf(B.charAt(0));
        if (index >=0 ){
            for (;index < n; index++) {
                dp[index][0] = 1;
            }
        }

        index = B.indexOf(A.charAt(0));
        if (index >=0 ){
            for (;index < m; index++) {
                dp[0][index] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int a = Math.max(dp[i-1][j], dp[i][j-1]);
                int b = 0;
                if (A.charAt(i) == B.charAt(j)) {
                    b= dp[i-1][j-1] + 1;
                }

                dp[i][j] = Math.max(a, b);
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        String A = "1A2C3D4B56";
        String B = "B1D23CA45B6A";
        System.out.println(findLCS(A, 10, B, 12));
    }

}
