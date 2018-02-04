/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.dp;

/**
 * Description:
 * 用动态规划的方法求解最长公共子序列
 *
 * Example:
 *   X = "ABCBDAB"  Y = "BDCABA"
 *
 * @author huaxin
 * @create 2018/01/29 21:26
 */
public class LCS {

    /**
     * 用递归的方法进行求解
     *             0  , i = m 或 j = n
     * LCS(i,j) =  1 + LCS(i+1, j+1)  , X[i] = Y[j]
     *             Max{LCS(i, j+1), LCS(i+1, j)}
     *
     * 时间复杂度接近于：O(2^n)
     *
     * @param X
     * @param m
     * @param Y
     * @param n
     * @return
     */
    public static int solu1(int []X, int i, int m, int []Y, int j,  int n) {
        if (i==m || j ==n) {
            return 0;
        }

        if (X[i] == Y[j]) {
            return 1+solu1(X, i+1, m, Y, j+1, n);
        }else {
            return Math.max(solu1(X, i, m, Y, j+1, n),solu1(X, i+1, m, Y, j, n));
        }
    }


    public static void main(String[] args) {
        int []X = {1,2,3,4,5,10};
        int []Y = {1,3,5,6,8,11};

        int result = solu1(X,0,X.length,Y,0,Y.length);
        System.out.println(result);
    }
}
