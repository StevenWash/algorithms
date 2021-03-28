/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Description:
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author huaxin
 * @create 2018/03/24 21:57
 */
public class GetLeastNumbers {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>();
        if (input == null || input.length <= 0) {
            return list;
        }
        if (k <= 0 || k > input.length) {
            return list;
        }

        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }

        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }

        return list;
    }

    public static void main(String[] args) {
        int [] arrs = {4,5,1,6,2,7,3,8};
        ArrayList list = GetLeastNumbers_Solution(arrs, 8);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

}
