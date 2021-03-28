/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise;

import java.io.IOException;
import java.util.Scanner;

/**
 * Description:
 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。
 * 例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,
 * 我们得到5231+1325=6556.如果颠倒之后的数字有前缀零,前缀零将会被忽略。
 * 例如n = 100, 颠倒之后是1.
 *
 * 输入描述: 输入包括一个整数n,(1 ≤ n ≤ 10^5)
 *
 * 输出描述: 输出一个整数,表示n的相反数
 *
 * 输入例子1: 1325
 * 输出例子1: 6556
 *
 * @author huaxin
 * @create 2018/03/20 19:44
 */
public class ReverseNumber {

    public static int solu(int n) {
        String str = n+"";
        while (str.charAt(str.length()-1) == '0') {
            str = str.substring(0, str.length()-1);
        }
        char[] strs = str.toCharArray();
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            char temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }

        int val = Integer.parseInt(new String(strs));
        val = val + n;
        return val;

    }

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(n);
            System.out.println(solu(n));

    }
}
