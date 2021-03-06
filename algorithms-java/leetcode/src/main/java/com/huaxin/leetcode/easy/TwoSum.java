/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.easy;

/**
 * #Case : 1
 *
 * #Description:
 *   1、 Given an array of integers, return indices of the two numbers such that
 *   they add up to a specific target.You may assume that each input would have
 *   exactly one solution, and you may not use the same element twice.
 *
 * #Example:
 *   Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] =
 *   2 + 7 = 9, return [0, 1].
 *
 * @author 鑫

 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {

    }
}
