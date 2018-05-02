/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.linklist;

import com.huaxin.niuke.common.ListNode;

/**
 * Description:
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。
 * 请保证其他元素的相对顺序。
 *
 * 测试样例： {1,2,3,4,3,2,1},2 {1,3,4,3,1}
 *
 * @author huaxin
 * @create 2018/03/20 17:23
 */
public class ClearValue {

    public static ListNode clear(ListNode head, int K) {
        while (head != null && head.val == K) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }

        ListNode p1, p2 = head;
        head = head.next;
        p1 = p2;

        while (head != null) {
            if (head.val == K) {
                head = head.next;
                p2.next = head;
            }else {
                p2 = head;
                head = head.next;
            }

        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode listNode1  =listNode.next;
        listNode1.next = new ListNode(3);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(4);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(5);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(6);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(7);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(8);

        ListNode node = clear(listNode, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
