/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.dp;

/**
 * Description:
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。  给定一个矩阵map及它的行数n和列数m，
 * 请返回最小路径和。保证行列数均小于等于100.
 *
 * 测试样例：
 * [[1,2,3],[1,1,1]],2,3
 *
 * 返回：4
 *
 * @author huaxin
 * @create 2018/03/07 21:30
 */
public class MinimumPath {

    public static int getMin(int[][] map, int n, int m) {
        int [][] dp = new int[n][m];

        if (n<=0 || m <= 0) {
            return 0;
        }

        /**
         * 这两个初始化的过程，原因是在第一行和第一列，从（0，0）位置开始，无论是去哪一个点都是经过的节点的值的累加
         */
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += map[0][j];
            }
            dp[0][i] = sum;
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += map[j][0];
            }
            dp[i][0] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = map[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{1,1,1}};
        System.out.println(getMin(nums, 2, 3));
    }

}
