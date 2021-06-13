//
// Created by 华鑫 on 2021/4/13.
//

/*
 *
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */

#include <iostream>
#include <algorithm>
#include "../common/TreeNode.h.bak"

using namespace std;

class BinTreeMaxDepth {
public:
    int maxDepth(TreeNode* root) {

        if (root == NULL) { return 0; }

        return max(maxDepth(root->left), maxDepth(root->right)) + 1;

    }
};

void test_maxDepth() {

    BinTreeMaxDepth binTreeMaxDepth;

    TreeNode treeNode;
    treeNode.val = 1;

    TreeNode t1;
    t1.val = 2;

    TreeNode t2;
    t2.val = 4;

    TreeNode t3;
    t3.val = 5;

    TreeNode t4;
    t4.val = 9;

    TreeNode t5;
    t5.val = 3;

    t1.right = &t3;
    t2.left = &t4;
    t2.right = &t5;

    treeNode.left = &t1;
    treeNode.right = &t2;

    binTreeMaxDepth.maxDepth(&treeNode);
}