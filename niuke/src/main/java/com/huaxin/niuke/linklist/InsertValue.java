/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.linklist;

import com.huaxin.niuke.common.ListNode;

/**
 * Description:
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 *
 * 测试样例： [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 *
 * @author huaxin
 * @create 2018/03/20 14:28
 */
public class InsertValue {

    public static ListNode insert(int[] A, int[] nxt, int val) {

        ListNode node = new ListNode(val);
        if (A.length <= 0 ) {
            return node;
        }

        ListNode head = new ListNode(A[0]);
        ListNode cur = head;

        for (int i = 0; i < A.length - 1; i++) {
            ListNode temp = new ListNode(A[nxt[i]]);
            cur.next = temp;
            cur = cur.next;
        }

        cur.next = head;
        cur = head;

        ListNode pre = cur.next;

        while (pre != head) {
            if (pre.val >= val && cur.val < val) {
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }

        if (pre == head) {
            cur.next = node;
            node.next = pre;
            if (cur.val < val) {
                node.next = null;
                return head;
            }else {
                cur.next = null;
                return node;
            }
        }
        cur.next = node;
        node.next = pre;

        while (cur.next != head) {
            cur = cur.next;
        }
        cur.next = null;

        return head;
    }

    public static void main(String[] args) {
        int [] A = {4,8,9};
        int [] B = {1,2,0};
        int val = 4;
        ListNode node = insert(A, B, val);
    }

}
