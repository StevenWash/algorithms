/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author huaxin
 * @create 2018/02/05 14:52
 */
public class NumberOf1 {

    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if((n&flag) != 0) {
                count++;
            }
            flag <<=1;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = -2147483648;
        int result = NumberOf1(n);
        System.out.println(result);
    }
}
