/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description:
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 *
 * 输入描述: 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
 *
 * 输出描述: 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
 *
 * 如样例所示: s = "aaabbaaac"
 * 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 *
 * 输入例子1: aaabbaaac
 *
 * 输出例子1: 2.25
 *
 * @author huaxin
 * @create 2018/03/20 20:02
 */
public class AvarageString {

    public static float solu(String s) {
        ArrayList<String> lists = new ArrayList<String>();

        char [] strs = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            while (i < strs.length - 1 && strs[i] == strs[i+1]) {
                str.append(strs[i]);
                i++;
            }
            str.append(strs[i]);
            lists.add(str.toString());

            str = new StringBuilder();
        }
        float sum = 0;
        for(String ss : lists) {
            sum += ss.length();
        }

        return sum / lists.size();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();

        System.out.printf("%.2f",solu("aaabbaaaccc"));
    }
}
