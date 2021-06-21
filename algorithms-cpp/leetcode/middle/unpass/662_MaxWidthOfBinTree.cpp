//
// Created by stevenhua on 2021/6/1.
//

#include "../../common/TreeNode.h"
#include <vector>
#include <cmath>


/**
 * 662. 二叉树最大宽度
 *
 *  给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入:

           1
         /   \
        3     2
       / \     \
      5   3     9

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
示例 2:

输入:

          1
         /
        3
       / \
      5   3

输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
示例 3:

输入:

          1
         / \
        3   2
       /
      5

输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
示例 4:

输入:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
注意: 答案在32位有符号整数的表示范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MaxWidthOfBinTree {
public:
    // 思路：1、首先求出每一层中遍历的每个节点和当前层最左边节点的距离，即该节点的宽度
    //      2、然后取最大宽度即为整棵树的宽度
    int widthOfBinaryTree(TreeNode* root) {

        // 边界值判断
        if (root == nullptr) {
            return 0;
        }

        if (root->left == nullptr && root->right == nullptr) {
            return 1;
        }

        // 存放当前最大的宽度
        int maxWidth = 0;

        // 存放每一层最左边的索引值
        std::vector<int> leftStart;

        // 初始化递归
        dfs(root, leftStart, 1, 1, maxWidth);

        return maxWidth;

    }

    // 深度优先搜索遍历二叉树
    // leftStart: 存放的是每一层最左边的元素的index值
    // index: 表示每个节点的索引值，节点从上到下，从左到右编号为1，2，3，4...
    //        参考满二叉树的索引，索引值为index，其左孩子为2index，右孩子为2index+1
    // depth: 用来表示当前遍历到第几层了
    void dfs(TreeNode *tree, std::vector<int>& leftStart, unsigned long long index, int depth, int &maxWidth) {

        // 边界值判断
        // 如果树为空，直接返回即可，什么都不用处理
        if (tree == nullptr) {
            return;
        }

        // 获取每一层最左边第一个元素的索引值
        if (depth > leftStart.size()) {
            // 因为leftStart中每层只存放了一个元素，因此，每一层的depth和leftStart的size是相等的
            // 如果depth更大，说明到新的一层了，需要了添加当前index到leftStart中
            leftStart.push_back(index);
        }

        // 表示当前遍历的节点index距离该层的第一个元素的距离值
        int curIndexWidth = index - leftStart[depth-1] + 1;
        // 取当前index节点的宽度和当前记录的最大宽度maxWidth中最大值
        maxWidth = std::max(maxWidth, curIndexWidth);

        // 递归遍历左子树
        if (index <= (pow(2, INT_MAX) - 1)/2) {
            dfs(tree->left, leftStart, 2*index, depth + 1, maxWidth);
        }
        // 递归遍历右子树
        if (index <= (pow(2, INT_MAX) - 2)/2) {
            dfs(tree->right, leftStart, 2 * index + 1, depth + 1, maxWidth);
        }
    }
};

// unpass
void test_662_width_of_binary_tree() {

    TreeNode tree;
    tree.val = 1;
    tree.left = new TreeNode(3);
    tree.right = new TreeNode(2);

    tree.left->left = new TreeNode(5);
    tree.right->right = new TreeNode(9);

    MaxWidthOfBinTree maxWidthOfBinTree;

    int res = maxWidthOfBinTree.widthOfBinaryTree(&tree);

    printf("res: %d\n", res);

}
