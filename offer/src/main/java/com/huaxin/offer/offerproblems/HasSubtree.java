/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author huaxin
 * @create 2018/02/05 19:50
 */
public class HasSubtree {

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isSameArch(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    public static boolean isSameArch(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }

        return isSameArch(tree1.left, tree2.left) && isSameArch(tree1.right, tree2.right);
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);

        TreeNode leftTree = new TreeNode(6);
        TreeNode rightTree = new TreeNode(10);

        treeNode.left = leftTree;
        treeNode.right = rightTree;

        leftTree.left = new TreeNode(5);
        leftTree.right = new TreeNode(7);

        rightTree.left = new TreeNode(9);
        rightTree.right = new TreeNode(11);

        TreeNode treeNode1 = new TreeNode(6);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(0);

        boolean result = HasSubtree(treeNode, treeNode1);
        System.out.println(result);

    }
}
