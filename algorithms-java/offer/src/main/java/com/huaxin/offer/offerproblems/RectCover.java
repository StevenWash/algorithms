/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author huaxin
 * @create 2018/02/05 14:28
 */
public class RectCover {

    public static int RectCover(int target) {

        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int [] rect = new int[1024];
        rect[1] = 1;
        rect[2] = 2;

        for (int i = 3; i <= target; i++) {
            rect[i] = rect[i - 1] + rect[i - 2];
        }

        return rect[target];
    }

    public static void main(String[] args) {
        int n = 10;
        int result = RectCover(n);
        System.out.println(result);
    }
}
