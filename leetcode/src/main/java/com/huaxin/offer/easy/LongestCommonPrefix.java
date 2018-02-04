package com.huaxin.easy;

/**
 * description :
 *   Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length<=0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (String s :strs) {
            if (s.length()<=0) {
                return "";
            }
        }
        StringBuffer prefix = new StringBuffer("");
        String pre_prefix = prefix.toString();
        int index = 0;
        prefix.append( strs[0].charAt(index++)+"");
        for (int j = 0 ;j< strs[0].length();j++) {
            for (int i=1; i< strs.length; i++) {
                if (!strs[i].startsWith(prefix.toString())) {
                    return pre_prefix;
                }
            }
            pre_prefix = prefix.toString();
            if (index >= strs[0].length()) {
                return pre_prefix;
            }
            prefix.append(strs[0].charAt(index++));
        }
        return pre_prefix;
    }

    public static void main(String[] args) {
        String [] strs = {"ajn", "ajl","ajj"};
        System.out.println(longestCommonPrefix(strs));
    }
}
