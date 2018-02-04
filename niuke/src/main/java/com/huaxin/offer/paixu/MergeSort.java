/*
 * Copyright (c) 2017.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.paixu;

/**
 * Description:
 * 用作编写归并排序的算法实现
 *
 * @author huaxin
 * @create 2017/12/05 16:49
 */
public class MergeSort {

    /**
     * 将两个已经有序的数组进行合并
     * @param arrs 数组的元素
     * @param low 数组的低位
     * @param mid 数组的中间位置
     * @param high 数组的最高位
     * @return
     */
    public static void mergeArray(int[] arrs, int low, int mid, int high, int[] temp) {
        int i = low, j = mid + 1, index = 0;
        while(i <= mid && j <= high) {
            if (arrs[i] < arrs[j]) {
                temp[index++] = arrs[i++];
            } else {
                temp[index++] = arrs[j++];
            }
        }

        while (j <= high) {
            temp[index++] = arrs[j++];
        }

        while (i <= mid) {
            temp[index++] = arrs[i++];
        }

        index = 0;
        //将temp中的元素全部拷贝到原数组中
        while(low <= high){
            arrs[low++] = temp[index++];
        }

    }

    /**
     * 分治的思想，通过递归，将一个大数组分解成两个小数组，然后对两个小数组分别进行排序
     * 排序完成之后再进行两个小数组的合并操作。
     * @param arrs
     * @param low
     * @param high
     * @param temp
     */
    public static void merge(int [] arrs, int low, int high, int [] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            merge(arrs, low, mid, temp);
            merge(arrs, mid + 1, high, temp);
            mergeArray(arrs, low, mid, high, temp);
        }
    }

    /**
     * 主体的归并算法的入口
     * @param arrs
     * @return
     */
    public static int[] mergeSort(int [] arrs) {
        int [] temp = new int[arrs.length];
        merge(arrs, 0, arrs.length - 1, temp);

        return temp;
    }


    public static void main(String[] args) {
        int [] a = {1,9,3,2,8,10,2,7,6,7,8,4};

        int []c = mergeSort(a);

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

}
