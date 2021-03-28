/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import java.util.ArrayList;

/**
 * Description:
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @author huaxin
 * @create 2018/02/07 21:16
 */
public class SumWithoutOperator {

    public static int Sum_Solution(int n) {
        if (n == 1){
            return 1;
        }
        return n + Sum_Solution(n-1);
    }

    public static void main(String[] args) {
        int n = 10;
        int result = Sum_Solution(n);
        System.out.println(result);
    }
}
