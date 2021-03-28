/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.dp;

/**
 * Description:
 * 用动态规划解决计算阶乘
 *
 * @author huaxin
 * @create 2018/01/29 21:05
 */
public class FactNumber {

    public static int[] FACT  = new int[1024];

    /**
     * 普通的递归实现，直接返回n*solu(n-1)
     *
     * 直接计算单个数n的阶乘的时间复杂度是O(n)，在使用动态规划之后，由于不存在重复计算子问题
     * 所以，实际效果上不会得到改善。但是如果计算的是多个数的阶乘？
     *
     * @param n
     * @return
     */
    public static int solu1(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        return n * solu1(n-1);
    }

    /**
     * 计算数组nums中每个元素值的阶乘，并通过nums返回
     *
     * 由于在计算m的时候得到m!的值，假设n>m，在计算n!的时候，可以直接返回n!的阶乘
     *
     * 在计算m的阶乘的时候，可以直接使用已经计算出来了的n的阶乘
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(max(m,n))
     * @param n
     * @return
     */
    public static int solu2(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        if (FACT[n] != 0) {
            return FACT[n];
        }
        return FACT[n] = n*solu2(n-1);

    }


    public static void main(String[] args) {
        int n = 30;

        int result = solu1(n);
        System.out.println(result);

        int result1 = solu2(n);
        System.out.println(result1);

    }
}
