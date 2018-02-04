package com.huaxin.easy;

import com.huaxin.utils.ListNode;

/**
 *  description :
 *    Merge two sorted linked lists and return it as a new list.
 *    The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     * 方法：用了递归的方法，简单一些
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode;
        if (l1.val<l2.val) {
            listNode = l1;
            listNode.next = mergeTwoLists(l1.next , l2);
        }else {
            listNode = l2 ;
            listNode.next = mergeTwoLists(l1,l2.next);
        }
        return listNode;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     * 方法： 直接进行循环比遍历
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = new ListNode(0);
        ListNode l1_temp;
        ListNode l2_temp ;
        listNode.next = l1;
        l1_temp = listNode;

        while (l1!=null&&l2!=null) {
            l2_temp = l2;
            if (l2.val>l1.val) {
                while(l1!=null&&l1.val<l2.val) {
                    listNode = l1;
                    l1 = l1.next;
                }
                l2 = l2.next;
                listNode.next =l2_temp ;
                if (l1!=null) { l2_temp.next = l1;
                }

                listNode = listNode.next;
            }else {
                l2 = l2.next;
                listNode.next = l2_temp;
                l2_temp.next = l1;
                listNode = listNode.next;
            }
        }
        l1_temp = l1_temp.next;
        return l1_temp;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(-9);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(7);
        l1.next.next.next=null;
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(7);
        l2.next.next=new ListNode(9);
        l2.next.next.next=null;

        System.out.println(mergeTwoLists(l1, l2));
    }
}
