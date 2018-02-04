/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.ListNode;

import java.util.ArrayList;

/**
 * Description:
 * 输入一个链表，从尾到头打印链表每个节点的值
 *
 * @author huaxin
 * @create 2018/02/05 11:19
 */
public class PrintLinkedList {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        int[] vals = new int[1024];
        int index = 0;
        vals[index++] = listNode.val;

        ListNode temp = listNode.next;

        while (temp != null) {
            vals[index++] = temp.val;
            temp = temp.next;
        }

        for (index--; index >= 0; ) {
            list.add(vals[index--]);
        }

        return list;
    }

    public static void main(String[] args) {
    }

}
