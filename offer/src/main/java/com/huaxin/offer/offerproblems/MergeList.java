/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.ListNode;

/**
 * Description:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author huaxin
 * @create 2018/02/05 17:11
 */
public class MergeList {

    public static ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode list1_b = list1;
        ListNode list;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list = list2;
                list2 = list2.next;

                list.next = list1.next;
                list1.next = list;
                while (list.next!=null && list.next.val <= list2.val) {
                    list = list.next;
                }
                list1 = list;
            }else {
                list1 = list1.next;
            }
        }

        if (list1 == null) {
            list1.next = list2;
        }

        return list1_b;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode listNode1  =listNode.next;
        listNode1.next = new ListNode(4);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(5);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(7);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(8);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);
        ListNode listNode3  =listNode2.next;
        listNode3.next = new ListNode(5);
        listNode3  =listNode3.next;
        listNode3.next = new ListNode(6);
        listNode3  =listNode3.next;
        listNode3.next = new ListNode(7);
        listNode3  =listNode3.next;
        listNode3.next = new ListNode(9);

        Merge(listNode, listNode2);

        int x = 1, y=2, z=3;
        System.out.println(x+y+++z);

    }

}
