/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author huaxin
 * @create 2018/02/07 21:06
 */
public class ArrayMultiply {

    public static int[] multiply(int[] A) {
        int [] B = new int[A.length];


        for (int i = 0; i < B.length; i++) {
            int sum = 1;

            for (int j = 0; j < A.length; j++) {
                if (j != i) {
                    sum *= A[j];
                }
            }
            B[i] = sum;
        }

        return B;
    }

    public static void main(String[] args) {
        int [] sums = {3,2,1,4,7,12,8};
        int [] result = multiply(sums);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
