/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.linklist;

import com.huaxin.niuke.common.ListNode;

/**
 * Description:
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。
 *
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 *
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 *
 * @author huaxin
 * @create 2018/03/20 16:06
 */
public class KInverse {

    public static ListNode inverse1(ListNode head, int K) {
        if (head == null || head.next == null || K < 2) {
            return head;
        }

        int[] stack = new int[K];
        int index = 0;
        stack[index++] = head.val;
        ListNode listNode = null, result = null;
        head = head.next;

        while (head != null) {
            while (index < K) {
                if (head == null) {
                    int [] ss = new int[index];
                    int index1 = 0;
                    while (index > 0) {
                        ss[index1++] = stack[--index];
                    }
                    while (index1 > 0) {
                        listNode.next = new ListNode(ss[--index1]);
                        listNode = listNode.next;
                    }
                    break;
                }else {
                    stack[index++] = head.val;
                    head = head.next;
                }
            }
            if (listNode == null) {
                listNode = new ListNode(stack[--index]);
            }
            while (index > 0){
                listNode.next = new ListNode(stack[--index]);
                if (result == null) {
                    result = listNode;
                }
                listNode = listNode.next;
            }
            index = 0;
        }

        return result;
    }

    public static ListNode inverse(ListNode head, int K) {
        if (K < 2) {
            return head;
        }
        ListNode cur = head;
        ListNode start = null;
        ListNode pre = null;
        ListNode next = null;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == K) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign(ListNode left, ListNode start, ListNode end,
                       ListNode right) {
        ListNode pre = start;
        ListNode cur = start.next;
        ListNode next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
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

        ListNode node = inverse1(listNode, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
