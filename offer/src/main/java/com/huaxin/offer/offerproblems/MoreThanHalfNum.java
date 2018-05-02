/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 * 如果不存在则输出0。
 *
 * @author huaxin
 * @create 2018/03/24 21:50
 */
public class MoreThanHalfNum {

    public static int MoreThanHalfNum_Solution(int [] array) {

        if (array.length <= 0) {
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int [] hash = new int[max+1];

        for (int i = 0; i < array.length; i++) {
            hash[array[i]]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (hash[array[i]] > (array.length / 2)) {
                return array[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int [] arrs = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(arrs));
    }

}
