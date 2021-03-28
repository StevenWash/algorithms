/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

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

    /**
     * 解题思路：
     *   1、分别用两个指针i,j从数组头和数组未开始进行遍历
     *   2、i发现一个奇数就将该数存在temp数组的ik位置，然后ik++
     *   3、j发现一个偶数就将该数存在temp数组的jk位置，然后jk--
     *   4、当ik > jk表示遍历结束了
     *   5、将temp中的元素赋值到array中
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param array
     */
    public static void reOrderArray(int [] array) {
        int i = 0, j = array.length - 1;
        int ik = i, jk = j;
        int [] temp = new int[array.length];

        for (;ik <= jk; i++, j-- ) {
            if (array[j] % 2 == 0) {
                temp[jk--] = array[j];
            }
            if (array[i] % 2 == 1) {
                temp[ik++] = array[i];
            }
        }

        for (int m = 0; m < temp.length; m++) {
            array[m] = temp[m];
        }

    }

    public static void reOrderArray2(int [] array) {
        int temp;
        for (int i = 0; i < array.length;i++) {
            for (int j = array.length - 1; j>i;j--) {
                if (array[j] % 2 == 1 && array[j - 1]%2 == 0) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
//                    swap(array[j], array[j-1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        reOrderArray2(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
