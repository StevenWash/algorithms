/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import java.util.ArrayList;

/**
 * Description:
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author huaxin
 * @create 2018/03/11 14:13
 */
public class MaxInWindows {

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (size <= 0) {
            return result;
        }

        for (int i = 0; i <= num.length - size; i++) {
            result.add(findMax(num, i, i+size));
        }

        return result;
    }

    public static int findMax(int[] nums, int begin, int end) {
        int max = nums[begin];
        for (int i = begin+1; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums = {2,3,4,2,6,2,5,1};

        ArrayList<Integer> res = maxInWindows(nums, 3);

        for (Integer in : res) {
            System.out.println(in);
        }

    }

}
