/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.ListNode;

/**
 * Description:
 * 输入一个链表，反转链表后，输出链表的所有元素。
 *
 * @author huaxin
 * @create 2018/02/05 16:59
 */
public class ReverseList {

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        int [] stack = new int[50];
        int index = 0;
        ListNode temp = head;
        stack[index++] = temp.val;
        temp = temp.next;

        while(temp != null) {
            stack[index++] = temp.val;
            temp = temp.next;
        }
        temp = head;
        index--;
        while (temp != null) {
            temp.val = stack[index--];
            temp = temp.next;
        }

        return head;
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

        ListNode node = ReverseList(listNode);
        System.out.println(node==null?"null":node.val);
    }
}
