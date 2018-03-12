/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.dp;

/**
 * Description:
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，
 * 每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 *
 * 测试样例： [1,2,3],[1,2,3],3,6
 *
 * 返回：6
 *
 * @author huaxin
 * @create 2018/03/08 10:29
 */
public class Backpack {

    public static int maxValue(int[] w, int[] v, int n, int cap) {
        // write code here

        int[][] dp = new int[n][cap+1];

        for (int i = 0; i <= cap; i++) {
            if (i >= w[0]) {
                dp[0][i] = v[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j < w[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n-1][cap];
    }

    public static void main(String[] args) {
        int[] w = {42,25,30,35,42,21,26,28};
        int[] v = {261,247,419,133,391,456,374,591};
        System.out.println(maxValue(w, v, 8, 297));
    }

}
