/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @author huaxin
 * @create 2018/02/05 20:15
 */
public class MirrorTree {

    public static void Mirror(TreeNode root) {
        if (root.left.left == null) {
            int temp = root.left.val;
            root.left.val = root.right.val;
            root.right.val = temp;
            return;
        }

        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return;
        }

        Mirror(root.left);
        Mirror(root.right);
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
