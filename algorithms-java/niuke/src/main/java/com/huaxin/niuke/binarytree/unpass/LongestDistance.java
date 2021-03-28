/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree.unpass;

import com.huaxin.niuke.common.TreeNode;

/**
 * Description:
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫作A到B的距离。
 * 对于给定的一棵二叉树，求整棵树上节点间的最大距离。  给定一个二叉树的头结点root，请返回最大距离。
 * 保证点数大于等于2小于等于500.
 *
 * @author huaxin
 * @create 2018/03/06 17:11
 */
public class LongestDistance {

    public static int findLongest(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int [] re = solu(root);

        int a = re[1] ;


        return a;
    }

    public static int[] solu(TreeNode root) {
        int [] result = new int[2];
        if (root == null) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        int [] re1 = solu(root.left);
        result[0] = re1[0];
        int [] re2 = solu(root.right);
        result[1] = re2[0];

        result[0] = Math.max(re1[0], re2[0]) + 1;
        result[1] = Math.max(re1[1] + re2[1] + 1, result[0] - 1);


        return result;
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
        tempTree.left = new TreeNode(10);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(11);

        tempTree = treeNode.right.right;
        tempTree.left = new TreeNode(12);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(13);


        System.out.println(findLongest(treeNode));
    }
}
