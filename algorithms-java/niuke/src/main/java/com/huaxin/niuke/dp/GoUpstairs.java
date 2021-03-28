/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.dp;

/**
 * Description:
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * 为了防止溢出，请将结果Mod 1000000007
 *
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 *
 *
 *
 * @author huaxin
 * @create 2018/03/07 21:17
 */
public class GoUpstairs {

    public static int countWays(int n) {
        int [] note = new int[n+1];

        if (n <= 0) {
            note[0] = 0;
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        note[1] = 1;
        note[2] = 2;

        for (int i = 3; i <= n; i++) {
            note[i] = (note[i-1] + note[i-2]) % 1000000007;
        }

        return note[n];
    }

    public static void main(String[] args) {
        int num = 3;
        System.out.println(countWays(num));
    }

}
