/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.easy;

/**
 * Description:
 *   Given a sorted array and a target value, return the index if the target is found.
 *   If not, return the index where it would be if it were inserted in order.
 *   You may assume no duplicates in the array.
 * <p></p>
 * Example 1:
 *   Input: [1,3,5,6], 5
 *   Output: 2
 * <p></p>
 * Example 2:
 *   Input: [1,3,5,6], 2
 *   Output: 1
 * <p></p>
 * Example 3:
 *   Input: [1,3,5,6], 7
 *   Output: 4
 * <p></p>
 * Example 1:
 *   Input: [1,3,5,6], 0
 *   Output: 0
 */
public class SearchInsertPosition {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int i;
        for (i=0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        int value = 0;
        System.out.println(searchInsert(nums, value));
    }
}
