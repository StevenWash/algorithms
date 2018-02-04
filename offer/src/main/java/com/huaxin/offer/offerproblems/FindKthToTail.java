/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.ListNode;

import java.util.HashMap;

/**
 * Description:
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author huaxin
 * @create 2018/02/05 16:43
 */
public class FindKthToTail {

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();

        int index = 1;
        map.put(index++, head);
        head  = head.next;
        while (head != null) {
            map.put(index++, head);
            head  = head.next;
        }
        if (k > index-1) {
            return null;
        }
        return map.get(index - k);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        ListNode listNode1  =listNode.next;
        listNode1.next = new ListNode(8);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(5);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(1);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(7);
        listNode1  =listNode1.next;

        ListNode node = FindKthToTail(listNode, 2);
        System.out.println(node==null?"null":node.val);
    }
}
