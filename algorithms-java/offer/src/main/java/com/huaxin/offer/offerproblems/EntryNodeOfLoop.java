/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.ListNode;

/**
 * Description:
 * 一个链表中包含环，请找出该链表的环的入口结点。
 *
 * @author huaxin
 * @create 2018/02/09 20:33
 */
public class EntryNodeOfLoop {

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode listNode;
        ListNode q = pHead, p = pHead;
        int count = 0;
        if (pHead == null || pHead.next == null) {
            return null;
        }
        q = q.next;
        p = p.next.next;

        while (q != null && p != null && p != q) {
            q = q.next;
            p = p.next.next;
        }

        if (p != null) {
            while (true) {
                q = q.next;
                count++;
                if (q == p) {
                    break;
                }
            }
            if (count == 1) {
               return p;
            }
        }else {
            return null;
        }

        q = pHead;
        p = q;
        while (true) {
            for (int i = 0; i < count; i++) {
                q = q.next;
            }
            if (p == q) {
                listNode = p;
                break;
            }
            p = p.next;
            q = p;
        }

        return listNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 2;

        ListNode listNode = new ListNode();


        listNode.val = 5;
        listNode.next = new ListNode();
        listNode = listNode.next;
        ListNode l1 = listNode;

        listNode.val = 3;
        listNode.next = new ListNode();
        listNode = listNode.next;

        listNode.val = 7;
        listNode.next = l1;

        head.next = l1;


        ListNode result = EntryNodeOfLoop(head);
        System.out.println(result.val);
    }

}
