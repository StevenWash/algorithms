/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.string;

/**
 * Description:
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6 返回：true
 *
 * 测试样例：
 * "()a()()",7 返回：false
 *
 * 测试样例：
 * "()(()()",7 返回：false
 *
 * @author huaxin
 * @create 2018/03/12 23:03
 */
public class Parenthesis {

    public static boolean chkParenthesis(String A, int n) {
        int num = 0;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                num++;
            } else if (A.charAt(i) == ')') {
                num--;
            }

            if (num < 0) {
                return false;
            }
        }

        if (num != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "()(()()";
        System.out.println(chkParenthesis(str, str.length()));
    }

}
