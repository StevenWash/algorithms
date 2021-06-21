// Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
// Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
// Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
// Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
// Vestibulum commodo. Ut rhoncus gravida arcu.

//
// Created by stevenhua on 2021/6/2.
//

#include <map>
#include <vector>
#include "../../common/TreeNode.h"

using namespace std;

/**
 *
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class BuildTreeWithPreInOrder {
private:
    map<int, int> index;
public:

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        // 边界值判断
        if (preorder.size() == 0 || preorder.size() != inorder.size()) {
            return nullptr;
        }

        int n = preorder.size();

        // 创建inorder的索引值，根据val找到其在inorder中下标
        for (int i = 0; i < n; i++) {
            index[inorder[i]] = i;
        }

        // 调用dfs遍历
        return dfs(preorder, 0, n, inorder, 0 , n);
    }

    TreeNode* dfs(vector<int>& preorder, int l_pre, int r_pre, vector<int>& inorder, int l_in, int r_in) {

        // 边界值判断
        if (l_pre >= r_pre) {
            return nullptr;
        }

        // 先序遍历最左边的元素就是整个树得root节点，先构建出root节点
        TreeNode* root = new TreeNode(preorder[l_pre]);

        // 中序遍历中，root节点的左边所有的元素就是左子树上的元素，root节点的右边的元素就是有子树上的节点
        // 获取root节点在中序遍历数组中的索引值，所以此时左子树的元素个数就是root_in - l_in，右子树的元素个数就是r_in - root_in
        int root_in = index[preorder[l_pre]];
        int left_size = root_in - l_in;

        root->left = dfs(preorder, l_pre+1, l_pre+left_size+1, inorder, l_in, l_in+left_size);
        root->right = dfs(preorder, l_pre+left_size+1, r_pre, inorder, l_in+left_size, r_in);

        return root;
    }
};

// unpass
void test_105_build_tree_with_pre_in_order() {

    vector<int> preorder;
    preorder.push_back(3);
    preorder.push_back(9);
    preorder.push_back(20);
    preorder.push_back(15);
    preorder.push_back(7);

    vector<int> inorder;
    inorder.push_back(9);
    inorder.push_back(3);
    inorder.push_back(15);
    inorder.push_back(20);
    inorder.push_back(7);

    BuildTreeWithPreInOrder tree;
    TreeNode* result = tree.buildTree(preorder, inorder);

    printf("result: %d\n", result->val);
}