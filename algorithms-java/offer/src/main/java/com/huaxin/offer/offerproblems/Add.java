/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author huaxin
 * @create 2018/02/04 20:03
 */
public class Add {

    public static int Add(int a,int b) {
        int jw=a&b;
        int jg=a^b;
        while(jw != 0)
        {
            int t_a=jg;
            int t_b=jw<<1;
            jw=t_a&t_b;
            jg=t_a^t_b;
        }
        return jg;
    }

    public static void main(String[] args) {
        int a = 10, b = 12;
        int result = Add(a, b);
        System.out.println(result);
    }
}
