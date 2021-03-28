/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author huaxin
 * @create 2018/03/24 22:06
 */
public class PrintMinNumber {

    public static String PrintMinNumber(int [] numbers) {
        String result = "";

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, new MyComparetor());

        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int [] arrs = {3,32,321};

        System.out.println(PrintMinNumber(arrs));
    }

}

class MyComparetor implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        return (o1+""+o2).compareTo(o2+""+o1);
    }

}
