/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise;

import java.util.Scanner;

/**
 * Description:
 * 例题说明：
 * 1、本题目为例题，不计分。
 * 2、在代码框中选择你擅长的语言，标准的输入输出代码将显示在代码框中，请作为参考。
 * 3、本次考试正式编程题均将遵循此输入输出规范，如已掌握规范请跳过此题，点击屏幕右下方“开始答题”按钮进入正式考题。
 * 4、在完成正式编程考题前，如果输入输出格式遇到问题，你可通过答题卡随时切换回本例题进行参考。 题目描述 求a+b的和
 *
 * @author huaxin
 * @create 2018/03/21 20:28
 */
public class Main {

    public static int solu(String[] strs) {
        int result = 0;

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i != j) {
                    String s = strs[i]+strs[j];
                    if (judge(s)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static boolean judge(String str) {
        if (str.length() == 1) {
            return true;
        }
        if (str == null || str.length() <= 0) {
            return false;
        }

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        String[] strs = new String[n];
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i < n && sc.hasNext()) {
            strs[i++] = sc.nextLine();
        }

        System.out.println(solu(strs));
    }

}
