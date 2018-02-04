/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素
 *
 * @author huaxin
 * @create 2018/02/05 13:28
 */
public class MinInRotateArray {

    public static int minNumberInRotateArray(int [] array) {
        if (array.length ==0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        int m = (l + r)/2;

        while (l < r-1) {
            if (array[m] >= array[l]) {
                l = m;
            }else {
                r = m;
            }
            m = (l + r)/2;
        }
        return array[l+1];
    }

    public static void main(String[] args) {
        int [] nums = {4,5,6,7,4};
        int min = MinInRotateArray.minNumberInRotateArray(nums);
        System.out.println(min);
    }

}
