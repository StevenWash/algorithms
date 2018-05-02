/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;

import java.util.ArrayList;

/**
 * Description:
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述: 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * @author huaxin
 * @create 2018/03/13 08:46
 */
public class Permutation {

    public ArrayList<String> Permutation(String str) {

        char[] strs = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {

            }
        }
        return null;
    }

}
