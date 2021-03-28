/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import java.util.Stack;

/**
 * Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * @author huaxin
 * @create 2018/02/04 17:13
 */
public class MinInStack {

    Stack<Integer> stack = new Stack<Integer>();
    int [] st = new int[1024];
    int index = 0;

    public void push(int node) {
        stack.push(node);
        st[index++] = node;
    }

    public void pop() {
        stack.pop();
        index--;
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = st[0];
        for (int i = 1; i < stack.size(); i++) {
            if (st[i] < min) {
                min = st[i];
            }
        }
        return min;
    }
}
