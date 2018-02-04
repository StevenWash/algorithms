/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.paixu;

/**
 * Description:
 * 实现计数排序
 *
 * @author huaxin
 * @create 2017/12/09 17:21
 */
public class CountSort {

    /**
     * 实现计数排序的过程
     *
     * 思路：
     *    1、通过扫描arrs数组获取最大值和最小值，从而得到桶数组targetArrs的大小k
     *    2、遍历数组arrs来统计其中每一个元素的的出现次数cn,然后将cn的值存在桶数组targetArrs的位置arrs[i]处
     *    3、将桶数组中的每个位置的元素值和前一个元素值相加：targetArrs[j] = targetArrs[j-1] + targetArrs[j];
     *    4、将arrs的值反向遍历输出到另一个数组中，在另一个数组中的位置即targetArrs数组中的相应元素位置的值
     *
     * 问题：
     *    1、由于桶数组是根据最大值和最小值进行创建的，所以，arrs[i] - min需要减去一个min才能表示
     *       arrs[i]元素值在targetArrs中 的位置，比如，arrs中的54，对应的targetArrs就是54-8的位置
     *    2、在第四步中，先获取到arrs[i]的值，然后根据该值，获取到在targetArrs中统计的序号，先将此序号
     *       自减1，然后的到的就是arrs[i]元素在arrs1中的位置，然后进行赋值。
     *
     * @param arrs
     * @return
     */
    public static int[] countSort(int [] arrs) {
        int [] arrs1 = new int[arrs.length];
        int max = arrs[0];
        int min = arrs[0];
        int k = 0;
        int i = 0;

        //1、遍历数组，得到最大值和最小值
        for (int val : arrs) {
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }

        //k表示桶数组的大小
        k = max - min +1;
        int [] targetArrs = new int[k];

        //2、遍历arrs，统计每个元素出现的次数
        for (i = 0; i < arrs.length; i++) {
            targetArrs[arrs[i]-min] ++;
        }

        //3、更新桶数组中的值：每个值等于自身值加上前一个元素的值
        for (i = 1; i < k; i++) {
            targetArrs[i] += targetArrs[i-1];
        }

        //4、将arrs中的元素倒序放在arrs1中
        for (i = arrs.length - 1; i >= 0; i--) {
            arrs1[--targetArrs[arrs[i]-min]] = arrs[i];
        }

        return arrs1;
    }

    public static void main(String[] args) {
        int arrs [] = {54,35,48,36,27,12,44,44,8,14,26,17,28};
        arrs = countSort(arrs);

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }

}
