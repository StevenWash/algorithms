/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.paixu;

/**
 * 对一个给定的数组进行选择排序，时间复杂度：O(N*N)
 */
public class SelectSort {

    /**
     * 简单实现了一个选择排序，需要注意的是记录最小值的位置的变量index，
     * 每次都需要重新设置，否则会被上一次的值污染，由于index表示的是当前最小值的位置，
     * 所以重新设置index的值的时候需要用i来设置
     * @param src
     * @return
     */
    public static int[] selectSort(int [] src) {
        int min, index;
        for (int i = 0; i < src.length; i++) {
            min = src[i];
            /**
             * index表示的是最小值的位置，在每次循环的时候最小值都是设置为这一次循环的第一个元素，所以index需要设置为i
             */
            index = i;
            for (int j = i+1; j < src.length; j++) {
                if (src[j]<min) {
                    min = src[j];
                    index = j;
                }
            }
            src[index] = src[i];
            src[i] = min;
        }
        return src;
    }

    public static void main(String[] args) {
        int [] src = {2,1,5,6,1,7,4,3,3,9,2,7};
        src = selectSort(src);

        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
    }

}
