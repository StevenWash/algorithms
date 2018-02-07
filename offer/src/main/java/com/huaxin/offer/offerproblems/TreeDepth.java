/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author huaxin
 * @create 2018/02/04 14:24
 */
public class TreeDepth {
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

//        leftTree.left = new TreeNode(5);
//        leftTree.right = new TreeNode(7);

//        rightTree.left = new TreeNode(9);
//        rightTree.right = new TreeNode(11);

        int result = TreeDepth(treeNode);
        System.out.println(result);
    }
}
