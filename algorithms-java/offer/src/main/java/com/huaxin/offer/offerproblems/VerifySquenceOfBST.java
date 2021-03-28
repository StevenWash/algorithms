/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author huaxin
 * @create 2018/02/04 19:09
 */
public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length <= 0 ) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    public static boolean judge(int [] nums, int l, int r) {
        if (r <= l) {
            return true;
        }
        int max = nums[r];
        int i = l;
        while (i <= r && nums[i] < max) {
            i++;
        }
        int index = i;
        for (; i < r; i++) {
            if (nums[i] < max){
                return false;
            }
        }
        return judge(nums, l, index - 1) && judge(nums, index, r-1);
    }

    public static void main(String[] args) {
        int [] nums = {7,9,8,14,13,18,15,10};
        boolean result = VerifySquenceOfBST(nums);
        System.out.println(result);
    }
}
