/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.utils;

/**
 * 简单工具类
 *
 * @author 鑫
 *
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", next=" + (next==null?"":next.toString()) + "]";
    }
}
