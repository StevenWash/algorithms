/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Description:
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 实现原理：
 *   1、首先，根据需求就是获取排序后的中间两个数或者一个数的值（中位数）
 *   2、实现原理：
 *      首先维持一个计数器count用来表示当前是第几个元素，当是第偶数个元素的时候先将元素放到大顶堆，
 *      然后从大顶堆中弹出当前最大的数放到小顶堆中，如果是第奇数个元素，则将元素放到小顶堆中，然后将当前小顶堆中的
 *      元素出堆，并放到大顶堆中
 *   3、最后将大顶堆和小顶堆中的堆顶元素取出，如果是
 *
 * @author huaxin
 * @create 2018/03/06 21:19
 * @since 1.8+
 */
public class MediaNum {

    private static int count = 0;
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int maxNum = maxHeap.poll();
            minHeap.offer(maxNum);
        } else {
            minHeap.offer(num);
            int minNum = minHeap.poll();
            maxHeap.offer(minNum);
        }
        count++;
    }

    public static Double GetMedian() {
        int v2 = minHeap.size() > 0 ? minHeap.peek() : 0;
        if (count % 2 == 0) {
            int v1 = maxHeap.size() > 0 ? maxHeap.peek() : 0;

            return new Double(v1 + v2) / 2;
        }
        return new Double(v2);
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,4,1,6,7,0,8};
        for (int i = 0; i < 9; i++) {
            int val = nums[i];
            Insert(val);
            System.out.println(GetMedian());
        }

        //System.out.println(GetMedian());

    }

}
