/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.easy;

/**
 * Description :
 *   Given a sorted array, remove the duplicates in-place such that
 *   each element appear only once and return the new length.
 *   Do not allocate extra space for another array, you must do this
 *   by modifying the input array in-place with O(1) extra memory.
 *
 * Note : in-place 原地算法（就地算法）
 *
 * Example:
 *
 *   Given nums = [1,1,2],
 *   Your function should return length = 2,
 *   with the first two elements of nums being 1 and 2 respectively.
 *   It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 时间复杂度较高
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0) {
            return 0;
        }
        int temp = nums[0];
        int index =0;
        int len = nums.length;
        for (int i =1; i<nums.length; i++) {
            index++;
            while(i<nums.length&&temp == nums[i]) {
                len--;temp = nums[i];
                i++;
            }
            if(i<nums.length) {
                nums[index] = nums[i];
                temp = nums[i];
            }
        }
        return len;
    }

    /**
     * 时间复杂度较低
     * @param nums
     * @return
     */
    public static int removeDuplicates_2(int[] nums) {
        if (nums==null||nums.length==0) {
            return 0;
        }
        int index =0;
        for (int i =index; i<nums.length; i++) {
            if (nums[index]!=nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    /**
     * 实现了将数组最后最后完整的显示出来
     * @param nums
     * @return
     */
    public static int[] removeDuplicates_1(int[] nums) {
        if (nums==null||nums.length==0) {
            return null;
        }
        int temp = nums[0];
        int len = nums.length;
        int len1=0;
        int k=0;

        for (int i =1; i<len; i++) {
            k = i;
            len1 = 0;
            if (temp == nums[k]) {
                while (k<len&&temp == nums[k]) {
                    len1++;
                    k++;
                }
                len = len-len1;
                for (int j = i;j<len;j++) {
                    nums[j] = nums[j+len1];
                }
            }
            temp = nums[i];
        }

        int [] nums_1 = new int[len];
        for (int i = 0;i< len;i++) {
            nums_1[i] = nums[i];
        }
        return nums_1;
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,5,5,6,7,7,7,9};
        int[] nums = {0,0,1,1,1,1,3,3,3,3,3};
        System.out.println(removeDuplicates_2(nums));
    }
}
