/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.ListNode;

import java.util.Stack;

/**
 * Description:
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * @author huaxin
 * @create 2018/02/09 14:41
 */
public class FindFirstCommonNode {

    /**
     * 找到第一个公共节点，意思是从这个公共节点之后的内容两个链表是一样的，因为每个节点的next指针只有一个
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        ListNode listNode = null;

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        while (!stack1.empty() && !stack2.empty() && stack1.peek().val == stack2.peek().val) {
            stack1.pop();
            listNode = stack2.pop();
        }

        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        ListNode listNode1  =listNode.next;
        listNode1.next = new ListNode(3);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(8);
        listNode1  =listNode1.next;
        listNode1.next = new ListNode(7);

        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(5);

        ListNode listNode3  =listNode2.next;
        listNode3.next = new ListNode(6);
        listNode3  =listNode3.next;
        listNode3.next = new ListNode(9);

        ListNode result = FindFirstCommonNode(listNode, listNode2);

    }
}
