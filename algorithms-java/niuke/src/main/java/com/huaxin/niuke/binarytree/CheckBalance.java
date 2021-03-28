/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNode;

/**
 * Description:
 * 判断一颗树是不是平衡二叉树
 *
 * @author huaxin
 * @create 2018/03/06 15:33
 */
public class CheckBalance {

    public static boolean check(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }else {
            return check(root.left) && check(root.right);
        }
    }

    /**
     * 获取树的高度
     * @param tree
     * @return
     */
    public static int getHeight(TreeNode tree) {
        if (tree == null) {
            return 0;
        }

        return Math.max(1 + getHeight(tree.left), 1 +getHeight(tree.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode tempTree = treeNode;
        tempTree.left = new TreeNode(2);
        tempTree.right = new TreeNode(3);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(4);
        tempTree.right = new TreeNode(5);
        tempTree = treeNode.right;
        tempTree.left = new TreeNode(6);
        tempTree.right = new TreeNode(7);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(8);
//        tempTree.right = new TreeNode(8);

        System.out.println(check(treeNode));
    }
}
