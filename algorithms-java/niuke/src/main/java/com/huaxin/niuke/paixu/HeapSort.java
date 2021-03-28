/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.paixu;

/**
 * Description:
 *    实现一个大顶堆的堆排序的过程
 *
 * @author huaxin
 * @create 2017/12/07 15:11
 */
public class HeapSort {

    /**
     * 完成堆排序
     *
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * 不稳定性算法：在exchange函数里面，每次交换的序号都是间隔了好几个位置的
     *
     * @param arrs
     * @return
     */
    public static int[] heapSort(int arrs[]) {
        int len = arrs.length;
        //调整生成初始的大顶堆
        for (int i = len/2 - 1; i >= 0; i--) {//从左到右第一个非叶子结点开始
            sink(arrs, i, len);
        }
        exchange(arrs, 0, len-1, len);//将堆顶元素放到最后，相当于弹出对顶元素
        len--;
        for (; len>0; len--) {
            sink(arrs, 0, len);//此时只需要对每次换到堆顶的元素进行下沉处理即可
            exchange(arrs, 0, len-1, len);
        }

        return arrs;
    }

    /**
     * 将数组arrs中的元素的第i号位置的元素进行调整，使得调整之后的堆满足大顶堆的要求
     *
     * 问题：
     *    while中的第一个if语句需要判断k+1<len，因为后面需要访问arrs[k+1]
     *
     * @param arrs
     * @param i 当前处理的元素的位置
     * @param N 数组的元素的个数
     */
    public static void sink(int arrs[], int i, int N) {
        int len = N;
        while (i < len) {
            int k = 2*(i+1)-1;//k指向左孩子
            if (k + 1 < len && arrs[k] < arrs[k+1]) {//找到左孩子和右孩子中最大的一个
                k++;
            }
            if (k < len && arrs[i] > arrs[k]) {//如果孩子节点中最大的值小于父节点的值，这结束，此时满足大顶
                break;
            }
            exchange(arrs, i, k, len);//否则交换父节点和最大的孩子节点
            i = k;//继续向下遍历
        }
    }

    /**
     * 交换数组中给定的两个位置的元素的值
     * @param arrs
     * @param a
     * @param b
     * @param N 表示数组的元素个数
     */
    public static void exchange(int arrs[], int a, int b, int N) {
        if (a < N && b < N) {
            int temp = arrs[a];
            arrs[a] = arrs[b];
            arrs[b] = temp;
        }
    }

    public static void main(String[] args) {
        int arrs [] = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        arrs = heapSort(arrs);

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }
}
