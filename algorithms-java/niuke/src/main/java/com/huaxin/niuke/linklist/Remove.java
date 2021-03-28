/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.linklist;

import com.huaxin.niuke.common.ListNode;

/**
 * Description:
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。  给定带删除的头节点和要删除的数字，请执行删除操作，返回删除后的头结点。链表中没有重复数字
 *
 * @author huaxin
 * @create 2018/03/20 15:13
 */
public class Remove {

    public static ListNode removeNode(ListNode pNode, int delVal) {
        // write code here
        if(pNode == null) {
            return null;
        }

        //要删除头节点
        if(pNode.val == delVal) {
            ListNode nextNode = pNode.next;
            pNode.next = null;
            return nextNode;
        }

        ListNode curNode = pNode.next;
        ListNode preNode = pNode;
        while(curNode != null) {
            if(curNode.val == delVal) {
                preNode.next = curNode.next;
                curNode = null;
                return pNode;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return pNode;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode re = removeNode(node, 1);
    }

}
