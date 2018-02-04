/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.dp;

/**
 * Description:
 * 实现最大连续子序列的和
 *
 * Example:
 *    {-2, 11, -4, 13, -5, 2}  ->  20(11-4+13)
 *    {1, -3, 4, -2, -1, 6}   ->  7(4-2-1+6)
 *
 * @author huaxin
 * @create 2018/01/31 20:32
 */
public class MaxContigousSum {

    /**
     * 使用原始的暴力解法
     *
     * 1、首先遍历子序列的长度：1 - nums.length
     * 2、根据长度，来求相应长度的子序列的元素的和，并找到最大值
     *
     * @param nums
     * @return
     */
    public static int solution1(int []nums) {
        int max = Integer.MIN_VALUE;
        int temp;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length - i ; j++) {
                temp = 0;
                for (int k = j; k <= i + j; k++) {
                    temp += nums[k];
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static int solution2(int []nums) {
        int max = Integer.MIN_VALUE;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
//        int [] nums = {-2, 11, -4, 13, -5, 2};
        int [] nums = {1, -3, 4, -2, -1, 6};
        int result = solution1(nums);
        System.out.println(result);

        int result1 = solution2(nums);
        System.out.println(result1);
    }

}
