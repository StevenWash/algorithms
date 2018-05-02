/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.stackandqueue;

/**
 * Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * @author huaxin
 * @create 2018/03/19 17:08
 */
public class SpecialStack {

    final static int MAX_STACK_SIZE = 100;

    private int[] stackData = new int[MAX_STACK_SIZE];
    private int[] minData = new int[MAX_STACK_SIZE];

    private int index1 = 0, index2 = 0;

    public void push(int node) {
        stackData[index1++] = node;
        if (index2 <= 0 || minData[index2-1] > node) {
            minData[index2++] = node;
        }else {
            int data = minData[index2-1];
            minData[index2++] = data;
        }
    }

    public void pop() {
        index2--;
        index1--;
    }

    public int top() {
        return stackData[index1-1];
    }

    public int min() {
        return minData[index2-1];
    }


}
