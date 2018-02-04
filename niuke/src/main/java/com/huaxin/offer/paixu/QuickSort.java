/*
 * Copyright (c) 2017.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.paixu;

/**
 * Description:
 * 进行简单的快速排序的实现
 *
 * @author huaxin
 * @create 2017/12/06 20:24
 */
public class QuickSort {

    /**
     * 思路：
     *    采用递归的方式进行快速排序的分治策略，首先找到确定位置的partition，
     *    然后，将partition的左边的数组的数据进行递归调用sort方法，
     *    同理，将partition的右边的数组的数据进行递归调用sort方法
     *
     * 问题：
     *    在的到partition之后，在数组中partition的位置的元素就是已经排序好了的元素
     *    所以在下一次的左右递归排序中，应该是不需要姜partition包含在内的，即，左边就是
     *    low -> partition - 1 , 右边的就是 partition + 1 -> high
     *
     * @param arrs
     * @param low
     * @param high
     */
    public static void sort(int [] arrs, int low, int high) {
        if (low <= high) {
            int partition = partition(arrs, low, high);
            sort(arrs, low, partition - 1);
            sort(arrs, partition+1, high);
        }
    }

    /**
     * 找到数组中的分割位置，这个位置上的元素就是已经排好位置的
     * 满足：
     *    1、在该位置的左边的值都小于该值
     *    2、大于该值的都在该值的右边
     *
     * 问题：
     *    定位了i和j的位置之后，需要再次判断一下i<=j，才能进行i和j的值进行交换，因为
     *    不确定上面的两个while语句的终止循环的条件是i<=j还是后面的值不满足，所以，如果
     *    i<=j终止的时候，就不能直接交换i和j的值
     *
     * @param arrs
     * @param low
     * @param high
     * @return
     */
    public static int partition(int [] arrs, int low, int high) {
        int i = low + 1, j = high;
        int val = arrs[low];
        int temp;
        while (i <= j) {
            while (i <=j && arrs[i] <= val) {
                i++;
            }
            while (i <=j && arrs[j] > val) {
                j--;
            }

            if (i<=j) {
                temp = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = temp;
                i++;j--;
            }

        }

        arrs[low] = arrs[i - 1];
        arrs[i - 1] = val;
        return i - 1;
    }

    /**
     * 实现快速排序的方法
     * @param arrs
     * @return
     */
    public static int[] quickSort(int [] arrs) {
        sort(arrs, 0, arrs.length - 1);
        return arrs;
    }

    public static void main(String[] args) {
        int [] a = {1,3,6,9,3,2,8,10,2,7,1,7,8,4,13};

        int []c = quickSort(a);

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
