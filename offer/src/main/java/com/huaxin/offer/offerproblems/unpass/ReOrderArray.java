/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;

/**
 * Description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author huaxin
 * @create 2018/02/05 16:31
 */
public class ReOrderArray {

    public static void reOrderArray(int [] array) {

    }

    public static void main(String[] args) {
        int [] nums = {2,1,5,7,6,3,9};
        reOrderArray(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
