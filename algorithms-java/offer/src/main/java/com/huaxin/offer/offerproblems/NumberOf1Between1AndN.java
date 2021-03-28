/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 *
 * @author huaxin
 * @create 2018/02/09 14:24
 */
public class NumberOf1Between1AndN {

    public static int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 2;
        int val;
        int tmp;

        if (n <= 10) {
            if (n == 10) {
                return 2;
            }else if (n == 0) {
                return 0;
            }else {
                return 1;
            }
        }

        for (int i = 11; i <= n; i++) {
            val = i;
            while (val != 0) {
                tmp = val%10;
                val = val/10;
                if (tmp == 1) {
                    cnt ++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n = 55;
        int result = NumberOf1Between1AndN_Solution(n);
        System.out.println(result);
    }
}
