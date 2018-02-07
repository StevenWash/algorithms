/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author huaxin
 * @create 2018/02/04 14:34
 */
public class IsBalancedTree {

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }

        return false;
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);

        TreeNode leftTree = new TreeNode(6);
        TreeNode rightTree = new TreeNode(10);

        treeNode.left = leftTree;
        treeNode.right = rightTree;

        leftTree.left = new TreeNode(5);
        leftTree.right = new TreeNode(7);

        rightTree.left = new TreeNode(9);
        rightTree.right = new TreeNode(11);

        boolean result = IsBalanced_Solution(treeNode);
        System.out.println(result);
    }
}
