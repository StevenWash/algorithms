/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 青蛙跳台阶
 *
 * @author huaxin
 * @create 2018/02/05 13:57
 */
public class JumpFloor {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target-1) + jumpFloor(target - 2);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param target
     * @return
     */
    public static int jumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int sum = 0;

        for (int i = 1; i < target; i++) {
            sum += jumpFloor(target-i);
        }
        return sum+1;
    }

    public static void main(String[] args) {
        int n = 3;
        int result = jumpFloor(n);
        System.out.println(result);

        int result2 = jumpFloor2(n);
        System.out.println(result2);
    }
}
