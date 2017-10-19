package com.huaxin.medium;

import com.huaxin.utils.ListNode;

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head,list = new ListNode(-1);
        head=list;
        int num = 0;
        while (l1 != null && l2 != null) {
            list.next=new ListNode(-1);
            list = list.next;
            list.val = (l1.val + l2.val) % 10 + num;
            if ((l1.val + l2.val) >= 10) {
                num = 1;
                if(l1.next==null&&l2.next!=null)
                    l2.next.val+=num;
                else if(l2.next==null&&l1.next!=null)
                    l1.next.val+=num;
                else if(l1.next==null&&l2.next==null){
                    list.next=new ListNode(num);
                    list=list.next;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(4);
        l1.next=new ListNode(5);
        l1.next.next=new ListNode(7);
        l1.next.next.next=null;
        ListNode l2=new ListNode(3);
        l2.next=new ListNode(5);
        l2.next.next=new ListNode(1);
        l2.next.next.next=null;

        System.out.println(AddTwoNumbers.addTwoNumbers(l1, l2).toString());
    }

}
