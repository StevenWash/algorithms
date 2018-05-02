/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise;

import java.util.Scanner;

/**
 * Description:
 * 输入一个二维数组，元素为非负整数，每行和每列都是从小到大有序的，请用C/C++实现最优算法判断一个元素是否在二维数组中。
 * 输入描述: 第1行：数组行数m，数组列数n，空格分隔 第2行：第1行数据，空格分隔 第3行：第2行数据，空格分隔
 * 第4行：第3行数据，空格分隔 ………… 第m+1行：要找的数字
 *
 * 例如： 4 5 1 2 3 4 5 2 3 4 5 6 3 4 5 6 7 4 5 6 7 8 6
 *
 * 输出描述: 1表示找到，0表示未找到
 * 例如： 1  如果出现输入数据错误，如：行数或列数格式错误/小于等于0、或者行或列数据缺失、待检验数格式错误等，均输出： input error
 *
 * 示例1
 * 输入 4 5
 * 1 2 3 4 5
 * 2 3 4 5 6
 * 3 4 5 6 7
 * 4 5 6 7 8
 * 6
 * 输出 1
 *
 * 示例2
 * 输入 2 3 1 4 7 2 5 8 3
 * 输出 0
 *
 * 示例3
 * 输入 3 3 1 2 3 4 5 6 7 8 10
 * 输出 input error
 *
 * @author huaxin
 * @create 2018/03/21 21:08
 */
public class Solution {

    public static int solu(int[][] arrs, int val) {
        int result = 0;

        for (int i = arrs.length - 1; i >=0; ) {
            for (int j = arrs[0].length - 1; j >= 0; ) {
                if (arrs[i][j] == val) {
                    return 1;
                }

                if (arrs[i][j] < val){
                    i++;
                    j--;
                }

                if (arrs[i][j] > val) {
                    i--;
                    j--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String s = sc1.nextLine();
        String [] ss = s.split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        if (n <= 0 || m <= 0) {
            System.out.println("input error");
            return;
        }
        int[][] arrs = new int[n][m];


        for(int i = 0; i < n; i++){
            String sss = sc1.nextLine();
            String[] str = sss.split(" ");
            if (str.length < m) {
                System.out.println("input error");
                return;
            }
            for(int j = 0; j < m; j++){

                arrs[i][j] = Integer.parseInt(str[j]);
            }
        }

        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();

//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                System.out.println(arrs[i][j]);
//            }
//        }

//        System.out.println(val);

        System.out.println(solu(arrs, val));
    }
}
