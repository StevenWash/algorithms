/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @author huaxin
 * @create 2018/02/05 20:15
 */
public class MirrorTree {

    /**
     * 解题思路：
     *   1、首先在纸上画出镜像树的样子
     *   2、遍历整棵树：
     *         a、如果该节点不为叶子结点，则交换其左右子树
     *         b、如果是叶子结点，则不进行操作
     *         c、同样遍历当前节点的左子树和右子树
     *
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            TreeNode treeNode = root.left;
            root.left = root.right;
            root.right = treeNode;

        }

        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
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

        Mirror(treeNode);

    }

}
