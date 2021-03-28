/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;

/**
 * Description:
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述: 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author huaxin
 * @create 2018/03/13 09:57
 */
public class FirstAppearingOnce {
    static int[] tables = new int[65535];
    static int cur = 0;
    static int lastCur = 0;
    static int cnt = 0;
    static int cnt2 = 0;

    public static void Insert(char ch) {
        if (cnt == 0) {
            tables[ch]++;
            cur = ch;
            cnt++;
        } else {
            tables[ch]++;
            if (ch == cur) {
                cnt = 0;
                cur = lastCur;
            }else {
                if (tables[ch] == 1 && cnt2 == 0) {
                    lastCur = ch;
                    cnt2++;
                }else {
                    if (ch == lastCur) {
                        cnt2 = 0;
                    }
                }
            }
        }
    }

    public static char FirstAppearingOnce() {
        return (char)cur;
    }

    public static void main(String[] args) {
        Insert('B');
        System.out.println(FirstAppearingOnce());

        Insert('a');
        System.out.println(FirstAppearingOnce());

        Insert('b');
        System.out.println(FirstAppearingOnce());

        Insert('y');
        System.out.println(FirstAppearingOnce());

        Insert('B');
        System.out.println(FirstAppearingOnce());

        Insert('a');
        System.out.println(FirstAppearingOnce());

        Insert('b');
        System.out.println(FirstAppearingOnce());

        Insert('y');
        System.out.println(FirstAppearingOnce());
    }

}
