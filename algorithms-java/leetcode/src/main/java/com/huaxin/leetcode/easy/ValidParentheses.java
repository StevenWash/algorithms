/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.easy;

/**
 * description :
 *   Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 *   determine if the input string is valid.The brackets must close in the correct order,
 *   "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        System.out.println("str:"+s);
        char[] stack = new char[s.length()];
        int index =0;
        char temp ;
        char str ;

        for (int i = 0 ;i< s.length();i++) {
            temp = s.charAt(i);
            System.out.println(temp);

            if(temp == '(' || temp =='[' || temp == '{') {
                stack[index++] = temp;
            }else if (temp == ')' || temp == ']' || temp == '}') {
                if (index <= 0) {
                    return false;
                }
                str = stack[--index];
                switch (temp) {
                    case ')' :{
                        if (str != '(') {
                            return false;
                        }
                        break;
                    }
                    case ']' : {
                        if (str != '[') {
                            return false;
                        }
                        break;
                    }
                    case '}' : {
                        if (str != '{') {
                            return false;
                        }
                        break;
                    }
                    default:
                        return false;
                }
            }else
                return false;
        }

        if (index==0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{{}}]"));
    }
}
