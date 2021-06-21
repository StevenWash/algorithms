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
#include <stack>
#include "../common/TreeNode.h"

using namespace std;

class BinTreeInorderTraversal {
public:

    // 迭代的方法实现
    // 思路： 模拟中序遍历的过程，先不断的把当前节点的左孩子节点入栈，直到最左边的叶子节点
    //       然后出栈当前栈顶的元素（即最左边的叶子节点），遍历该节点的值，
    //       然后用同样的方式遍历该节点的右子树
    vector<int> inorderTraversal2(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> stack;

        while(root != nullptr || !stack.empty()) {
            while(root != nullptr) {
                stack.push(root);
                root = root->left;
            }

            root = stack.top();
            stack.pop();
            res.push_back(root->val);
            root = root->right;
        }

        return res;
    }


    // 递归的方法实现
    vector<int> inorderTraversal(TreeNode* root) {

        vector<int> res;
        traversal(root, &res);

        return res;
    }

    void traversal(TreeNode* root, vector<int> *res) {
        if (root == NULL) {
            return;
        }

        traversal(root->left, res);
        res->push_back(root->val);
        traversal(root->right, res);
    }
};

// pass
void test_94_inorder_traversal() {

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

    auto res1 = binTreeInorderTraversal.inorderTraversal(&treeNode);
    for (auto val: res1) {
        std::cout << val << " ";
    }
    std::cout << std::endl;

    TreeNode tree2;
    tree2.val = 1;

    TreeNode t6;
    t6.val = 2;

    TreeNode t7;
    t7.val = 3;

    t6.left = &t7;

    tree2.right = &t6;

    auto res2 = binTreeInorderTraversal.inorderTraversal2(&tree2);
    for (auto val: res2) {
        std::cout << val << " ";
    }
    std::cout << std::endl;

}