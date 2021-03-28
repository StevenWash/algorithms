/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.linklist;

import com.huaxin.niuke.common.ListNode;

import java.util.List;

/**
 * Description:
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，
 * 同时保证两类结点内部的位置关系不变。
 *
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 *
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 *
 * @author huaxin
 * @create 2018/03/19 19:19
 */
public class Divide {

    /**
     * 思路：
     * 用三个指针分别指向小于val，等于val，大于val的链表的节点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode listDivide(ListNode head, int val) {
        ListNode pp1 = null, p1 = null, pp2 = null, p2 = null, pp3 = null, p3 = null;

        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.val < val) {
                if (p1 == null) {
                    p1 = head;
                    pp1 = p1;
                }else {
                    p1 = head;
                }

                if (p2 != null) {
                    p2.next = head.next;
                }
                if (p3 != null) {
                    p3.next = head.next;
                }
            }else if (head.val == val) {
                if (p2 == null) {
                    p2 = head;
                    pp2 = p2;
                }else {
                    p2 = head;
                }
                if (p1 != null) {
                    p1.next = head.next;
                }
                if (p3 != null) {
                    p3.next = head.next;
                }
            } else {
                if (p3 == null) {
                    p3 = head;
                    pp3 = p3;
                }else {
                    p3 = head;
                }
                if (p2 != null) {
                    p2.next = head.next;
                }
                if (p1 != null) {
                    p1.next = head.next;
                }
            }
            head = head.next;
        }

        if (pp2 != null) {
            head = pp2;
            if (pp1 != null) {
                p2.next = pp1;
                p1.next = pp3;
            }else {
                p2.next = pp3;
            }
        }else {
            if (pp1 != null) {
                head = pp1;
                p1.next = pp3;
            }else {
                head = pp3;
            }
        }

        return head;
    }

    /**
     * 思路：
     * 用三个指针分别指向小于val，等于val，大于val的链表的节点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode listDivide1(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        int [] nodes = new int[100];
        int index = 0;

        while (head != null){
            nodes[index++] = head.val;
            head = head.next;
        }

        int i = 0, j = index - 1;
        while (i < j) {
            while (i < j && nodes[i] < val) {
                i++;
            }

            while (i < j && nodes[j] >= val) {
                j--;
            }

            int temp = nodes[i];
            nodes[i] = nodes[j];
            nodes[j] = temp;
            i++;j--;
        }
        ListNode node = new ListNode();
        head = node;
        for (int k = 0; k < index - 1; k++) {
            node.val = nodes[k];
            node.next = new ListNode(nodes[k+1]);
            node = node.next;
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
        listNode1.next = new ListNode(3);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(5);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(1);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(7);

        ListNode node = listDivide(listNode, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
