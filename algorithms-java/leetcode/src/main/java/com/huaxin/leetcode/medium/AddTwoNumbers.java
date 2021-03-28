/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.leetcode.medium;

import com.huaxin.leetcode.utils.ListNode;

/**
 * #Case 2
 *
 * #Description
 *   You are given two non-empty linked lists representing two non-negative integers.
 *   The digits are stored in reverse order and each of their nodes contain a single digit.
 *   Add the two numbers and return it as a linked list.You may assume the two numbers do not
 *   contain any leading zero, except the number 0 itself.
 *
 * #Example
 *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *   Output: 7 -> 0 -> 8
 *
 * #Note
 *   说明：目前实现的功能不够完善：
 *
 * Input:[1,8][0]
 *
 * Output:[1]
 *
 * Expected:[1,8]
 *
 * @author 鑫

 */
public class AddTwoNumbers {

    /**
     * 时间复杂度较小
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode l1_pre = l1;
        int val;
        while (l1 != null && l2 != null) {
           l1.val+=l2.val;
           l1_pre = l1;
           l1 = l1.next;
           l2 = l2.next;
        }
        if (l1 == null) {
            l1_pre.next = l2;
        }
        l1 = temp;
        while (l1!=null) {
            val = l1.val;
            if (val>=10) {
                l1.val = val%10;
                if (l1.next==null) {
                    l1.next = new ListNode(0);
                }
                l1.next.val+=val / 10;
            }
            l1 = l1.next;
        }
        return temp;
    }

    /**
     * 时间复杂度较大
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode l1_temp = temp;
        ListNode temp_pre = temp;
        int val;
        while (l1 != null && l2 != null) {
            val = l1.val+l2.val;
            temp.val += val;
            temp.next = new ListNode(0);
            temp_pre = temp;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            temp_pre.next = l2;
        }
        if (l2 == null) {
            temp_pre.next = l1;
        }
        temp = l1_temp;
        while (temp!=null) {
            val = temp.val;
            if (val>=10) {
                temp.val = val%10;
                if (temp.next==null) {
                    temp.next = new ListNode(0);
                }
                temp.next.val+=val / 10;
            }
            temp = temp.next;
        }
        return l1_temp;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        l1.next.next.next=null;
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        l2.next.next.next=null;

        System.out.println(addTwoNumbers(l1, l2).toString());
    }

}
