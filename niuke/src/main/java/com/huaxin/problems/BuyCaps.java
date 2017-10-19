package com.huaxin.problems;

import java.util.Scanner;

/**
 * #Case 1
 *
 * #Description
 *   輸入描述：首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 *   輸出描述：如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 *
 * #Example
 *   輸入示例：
 *   10
 *   10 10 10 10 20 20 30 30 40 40
 *   輸出示例：
 *   30
 *
 * @author 鑫
 *
 */
public class BuyCaps {
    final static int rank = 3;

    public static int solve(int N, int[] prices) {
        if (N >= rank && prices != null) {
            int temp = 0;
            int index = 0;
            int[] stack = new int[rank];
            // 冒泡排序

            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (prices[j] > prices[j + 1]) {
                        temp = prices[j];
                        prices[j] = prices[j + 1];
                        prices[j + 1] = temp;
                    }

                }
            }

            stack[index++] = prices[0];
            for (int i = 1; i < N;) {
                if ((prices[i] == stack[index - 1])) {
                    i++;
                } else {
                    stack[index++] = prices[i++];
                    if (index == rank)
                        return stack[index - 1];
                }
            }
        }else
            return -1;
        return -1;
    }

    public static void main(String[] args) {
        int[] prices = null ;
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        prices=new int[N];
        for(int i=0;i<N;i++){
            prices[i]=sc.nextInt();
        }
        sc.close();
        System.out.println(BuyCaps.solve(N, prices));
    }

}