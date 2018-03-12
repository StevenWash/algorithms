/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words. For example, given s ="leetcode", dict =["leet", "code"]. Return true because"leetcode"can be segmented as"leet code".
 *
 * @author huaxin
 * @create 2018/03/08 16:15
 */
public class WordBreak {

    public static boolean wordBreak(String s, Set<String> dict) {
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                boolean flag = dp[j] && dict.contains(s.substring(j, i));
                if (flag) {
                    dp[i] = flag;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String a = "leetcode";
        Set<String> dic = new HashSet<String>();
        dic.add("leet");
        dic.add("code");
        System.out.println(wordBreak(a, dic));
    }

}
