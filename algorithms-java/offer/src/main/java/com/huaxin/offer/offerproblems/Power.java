/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author huaxin
 * @create 2018/02/05 16:19
 */
public class Power {

    public static double Power(double base, int exponent) {
        double sum = base;
        int abs = Math.abs(exponent);

        if (exponent == 0) {
            return 1;
        }

        for (int i = 1; i < abs; i++){
            sum *= base;
        }

        if (exponent > 0) {
            return sum;
        }else {
            return 1/sum;
        }
    }

    public static void main(String[] args) {
        double d = 2;
        int i = -3;
        double result = Power(d, i);
        System.out.println(result);
    }

}
