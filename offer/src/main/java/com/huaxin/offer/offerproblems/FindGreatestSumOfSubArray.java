/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 最大子数组和
 *
 * @author huaxin
 * @create 2018/02/07 21:51
 */
public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int curSum = array[0];
        int lastSum = Integer.MIN_VALUE;

        for(int i = 1; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if (curSum > lastSum) {
                lastSum = curSum;
            }
        }
        return lastSum;
    }

    public static void main(String[] args) {
        int [] nums = {6,-3,-2,7,-15,1,2,2};
        int result = FindGreatestSumOfSubArray(nums);
        System.out.println(result);
    }
}
