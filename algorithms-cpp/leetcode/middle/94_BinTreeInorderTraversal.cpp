//
// Created by 华鑫 on 2021/4/13.
//

/*
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。

 

示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]
 

提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100

 */


#include <iostream>
#include <vector>
#include "../common/TreeNode.h.bak"

using namespace std;

class BinTreeInorderTraversal {
public:
    vector<int> inorderTraversal(TreeNode* root) {

        vector<int> res;
        inorderTraversal(root, &res);

        return res;

    }

    void inorderTraversal(TreeNode* root, vector<int> *res) {

        if (root == NULL) {
            return;
        }

        inorderTraversal(root->left, res);
        res->push_back(root->val);
        inorderTraversal(root->right, res);

    }
};

void test_inorderTraversal() {

    BinTreeInorderTraversal binTreeInorderTraversal;

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

    binTreeInorderTraversal.inorderTraversal(&treeNode);

}