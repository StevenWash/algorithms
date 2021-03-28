//
// Created by 华鑫 on 2021/3/8.
//

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

#include "../common/ListNode.h"
#include <iostream>

using namespace std;

/*
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例1：
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例2：
 *
 * 输入：l1 = [], l2 = []
   输出：[]

   示例 3：

   输入：l1 = [], l2 = [0]
   输出：[0]

   提示：

   两个链表的节点数目范围是 [0, 50]
   -100 <= Node.val <= 100
   l1 和 l2 均按 非递减顺序 排列

*/
class MergeSortedLinkedList {

public:

    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {

        if (l1 == NULL) {
            return l2;
        }

        if (l2 == NULL) {
            return l1;
        }

        ListNode* tmpNode;

        if (l1->val > l2->val) {
            tmpNode = l1;
            l1 = l2;
            l2 = tmpNode;
        }

        ListNode* head = l1;
        tmpNode = NULL;

        while (l1 != NULL && l2 != NULL) {

            while (l1 != NULL && l1->val <= l2->val) {
                tmpNode = l1;
                l1 = l1->next;
            }

            if (tmpNode != NULL) {
                tmpNode->next = l2;
                l2 = l2->next;
                tmpNode = tmpNode->next;
                tmpNode->next = l1;
            }
        }

        if (l1 == NULL) {
            tmpNode->next = l2;
        }

        return head;
    }

    // 递归的实现方式
    ListNode* mergeTwoLists2(ListNode* l1, ListNode* l2) {

        if (l1 == NULL) {
            return l2;
        }

        if (l2 == NULL) {
            return l1;
        }

        if (l1->val < l2->val) {
            l1->next = mergeTwoLists2(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoLists2(l1, l2->next);
            return l2;
        }

    }

};

void test_merge_sorted_linked_list() {
    MergeSortedLinkedList merge;

    ListNode * l1 = new ListNode(2);
    l1->next = new  ListNode(3);
    l1->next->next = new  ListNode(5);
    l1->next->next->next = new  ListNode(5);
    l1->next->next->next->next = new  ListNode(7);
    l1->next->next->next->next->next = new  ListNode(15);


    ListNode * l2 = new ListNode(1);
    l2->next = new  ListNode(4);
    l2->next->next = new  ListNode(5);
    l2->next->next->next = new  ListNode(8);
    l2->next->next->next->next = new  ListNode(9);
    l2->next->next->next->next->next = new  ListNode(12);

    ListNode * result = merge.mergeTwoLists2(l1, l2);
    while(result != NULL) {
        std::cout << result->val << std::endl;
        result = result -> next;
    }

}
