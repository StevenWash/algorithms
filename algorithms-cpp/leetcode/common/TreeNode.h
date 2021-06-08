//
// Created by 华鑫 on 2021/3/8.
//

#ifndef ALGORITHM_CPP_TREENODE_H
#define ALGORITHM_CPP_TREENODE_H

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


#endif //ALGORITHM_CPP_TREENODE_H
