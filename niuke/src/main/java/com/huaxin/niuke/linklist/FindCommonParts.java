/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.linklist;

import com.huaxin.niuke.common.ListNode;

import java.util.ArrayList;

/**
 * Description:
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。  给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值  测试样例： {1,2,3,4,5,6,7},{2,4,6,8,10} 返回：[2.4.6]
 *
 * @author huaxin
 * @create 2018/03/20 15:55
 */
public class FindCommonParts {

    public int[] findCommonParts(ListNode headA, ListNode headB) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (headA == null || headB == null) {
            return null;
        }
        ListNode r1 = headA, r2 = headB;

        while (r1 != null && r2 != null) {
            if (r1.val < r2.val) {
                r1 = r1.next;
            } else if (r2.val < r1.val) {
                r2 = r2.next;
            }else {
                list.add(r1.val);
                r1 = r1.next;
                r2 = r2.next;
            }
        }

        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
