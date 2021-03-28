/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise;

import com.sun.tools.internal.xjc.SchemaCache;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description:
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题: 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 *
 * 输入描述:
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10), 接下来每两行描述一个数列A,
 * 第一行为数列长度n(1 ≤ n ≤ 10^5) 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 *
 * 输出描述:
 * 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 *
 * 输入例子1:
 * 2
 * 3
 * 1 10 100
 * 4
 * 1 2 3 4
 * 输出例子1:
 * Yes
 * No
 *
 * @author huaxin
 * @create 2018/03/20 20:47
 */
public class SpecialNum {

    public static ArrayList solu(int [][] arrs) {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0 ; j < arrs[i].length - 1; j++) {
                if (arrs[i][j] * arrs[i][j+1] % 4 != 0) {
                    list.add("No");
                }
            }
            if (list.get(i) == null) {
                list.add("Yes");
            }
        }

        return list;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int s = Integer.parseInt(scanner.nextLine());
        System.out.println("s:"+s);
        int [][] nums = new int[s][];
        for (int i = 0; i < s; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            nums[i] = new int[n];
            String str = scanner.nextLine();
            String [] strs = str.split(" ");
            for (int j = 0; j < n; j++){
                nums[i][j] = Integer.parseInt(strs[j]);
            }
        }

        solu(nums);
    }

}
