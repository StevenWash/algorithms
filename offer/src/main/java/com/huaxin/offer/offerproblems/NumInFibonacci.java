/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
 *
 * @author huaxin
 * @create 2018/02/05 13:46
 */
public class NumInFibonacci {

    public static int fibonacci(int n) {
        int [] fab = new int[40];
        if (n == 0 ) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        fab[0] = 0;
        fab[1] = 1;
        fab[2] = 1;

        for (int i = 3; i <= n; i++) {
            fab[i] = fab[i-1] + fab[i-2];
        }

        return fab[n];
    }

    public static void main(String[] args) {
        int n = 20;
        int result = fibonacci(n);
        System.out.println(result);
    }

}
