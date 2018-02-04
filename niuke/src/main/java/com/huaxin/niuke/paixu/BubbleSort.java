/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.paixu;

/**
 * 实现一个冒泡排序
 * 时间复杂度：O(N*N)
 */
public class BubbleSort {

    /**
     * 实现冒泡排序，思路非常简单，直接两遍循环即可
     * @param src
     * @return
     */
    public static int [] bubbleSort(int [] src) {
        int temp ;
        for (int i = src.length; i > 0; i--) {
            for (int j = 0; j < i-1;j++) {
                if (src[j] > src[j+1]) {
                    temp = src[j];
                    src[j] = src[j+1];
                    src[j+1] = temp;
                }
            }
        }
        return src;
    }

    public static void main(String[] args) {
        int [] src = {2,1,5,4,3,3,9};
        src = bubbleSort(src);

        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
    }
 }
