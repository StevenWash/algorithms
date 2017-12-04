package com.huaxin.string;

/**
 * 将一个字符串进行逆序输出
 */
public class ReverseWord {

    /**
     * 将一个给定的字符串进行逆序输出
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        int i = 0, j = str.length()-1;
        char []strs = str.toCharArray() ;
        char s;
        for (; i < j; i++ , j--) {
            s = strs[i];
            strs[i] = strs[j];
            strs[j] = s;
        }
        return new String(strs);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg"));
    }
}
