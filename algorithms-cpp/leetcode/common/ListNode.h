//
// Created by 华鑫 on 2021/3/8.
//

#ifndef ALGORITHM_CPP_LISTNODE_H
#define ALGORITHM_CPP_LISTNODE_H

// Linked List
class ListNode {

public:

    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


#endif //ALGORITHM_CPP_LISTNODE_H
