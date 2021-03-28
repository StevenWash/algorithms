/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Description:
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 *
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author huaxin
 * @create 2018/03/13 09:43
 */
public class ReverseSentence {

    public static String ReverseSentence(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }

        str = reverse(str);
        String[] strs = str.split(" ");
        if (strs.length <= 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            stringBuilder.append(reverse(strs[i])+" ");
        }

        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    public static String reverse(String str) {
        char temp;
        char[] strs = str.toCharArray();
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        return new String(strs);
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(ReverseSentence(str));
    }

}
