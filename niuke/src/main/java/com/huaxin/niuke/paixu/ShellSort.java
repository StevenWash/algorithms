/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.paixu;

/**
 * Description:
 *    实现希尔排序
 *
 * @author huaxin
 * @create 2017/12/08 12:54
 */
public class ShellSort {

    /**
     * 思路：
     *    1、先获取开始的增量值，应该取一个尽可能大的增量值，增量方式有如下几种方式：
     *       N = N/2     N = N/3
     *    2、然后有两个for循环，外层for循环用来遍历整个排序数组
     *       内层for循环用来遍历一次小组内的排序
     *    3、在完成一次两个for之后，就需要更新一下N的值：
     *       N = N/2  或者  N = N/3
     *    4、上述的2、3租后的终止条件是N<1
     *
     * 说明：
     *    1、实际上while里面的两个for循环就是一个插入排序的过程，只不过增加的步数是N而不是1
     *    2、增量N还可以有其他的很多方式表达
     *
     * @param arrs
     * @return
     */
    public static int [] shellSort(int []arrs) {
        int len = arrs.length;
        int N = len / 2;

        while (N >= 1) {
            for (int i = N; i < len; i+=N) {
                for (int j = i; j - N >= 0 && arrs[j] < arrs[j - N]; j -= N) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j - N];
                    arrs[j - N] = temp;
                }
            }
            N = N / 2;
        }

        return arrs;
    }

    public static void main(String[] args) {
        int arrs [] = {1,11,0,2,4,2,7,9,10,8,3,5,-1,14,6,5,1,8};
        arrs = shellSort(arrs);

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }
}
