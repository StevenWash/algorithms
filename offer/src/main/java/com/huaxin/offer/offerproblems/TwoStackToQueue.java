/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import java.util.Stack;

/**
 * Description:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author huaxin
 * @create 2018/02/05 12:51
 */
public class TwoStackToQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int v = stack2.pop();
        stack1.clear();
        while(!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return v;
    }

}
