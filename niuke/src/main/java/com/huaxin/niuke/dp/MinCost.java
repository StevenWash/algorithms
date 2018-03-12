/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.dp;

/**
 * Description:
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，
 * 请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 *
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
 *
 * 保证两串长度均小于等于300，且三种代价值均小于等于100。
 *
 * 测试样例： "abc",3,"adc",3,5,3,100
 *
 * 返回：8
 *
 * @author huaxin
 * @create 2018/03/08 11:20
 */
public class MinCost {

    public static int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {

        /**
         * 在（0，0）位置是表示空字符串
         */
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0;

        for (int i = 1; i < m+1; i++) {
            dp[0][i] = i * c0;
        }

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = i * c1;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int cost1, cost2, cost3;
                /**
                 * 有四个来源
                 */
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    cost1 = dp[i-1][j-1];
                }else {
                    cost1 = dp[i-1][j-1] + c2;
                }

                cost2 = dp[i-1][j] + c1;
                cost3 = dp[i][j-1] + c0;

                dp[i][j] = Math.min(Math.min(cost1,cost2), cost3);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String A = "bbca";
        String B = "cabacab";
        System.out.println(findMinCost(A, 4, B, 7, 1,2, 7));
    }

}
