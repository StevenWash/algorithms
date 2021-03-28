/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.string;

import com.huaxin.niuke.common.TreeNode;

/**
 * Description:
 * 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 *
 * @author huaxin
 * @create 2018/03/12 19:54
 */
public class IdenticalTree {

    public static boolean chkIdentical(TreeNode A, TreeNode B) {
        String str1 = serial(A);
        String str2 = serial(B);
        return (FindSubString.KMP(str1, str2) != -1);
    }

    /**
     * 先序遍历序列化
     * @param tree
     * @return
     */
    public static String serial(TreeNode tree) {
        StringBuilder result = new StringBuilder();

        if (tree == null) {
            return "#!";
        }

        result.append(tree.val + "!");
        result.append(serial(tree.left));
        result.append(serial(tree.right));

        return result.toString();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode tempNode = treeNode.left;

        tempNode.left = new TreeNode(4);
        tempNode.right = new TreeNode(5);

        tempNode = treeNode.right;
        tempNode.left = new TreeNode(6);
        tempNode.right = new TreeNode(7);

        TreeNode treeNode1 = new TreeNode(1);
//        treeNode1.left = new TreeNode(2);
//        treeNode1.right = new TreeNode(3);
//
//        TreeNode tempNode1 = treeNode1.left;
//
//        tempNode1.left = new TreeNode(4);
//        tempNode1.right = new TreeNode(5);
//
//        tempNode1 = treeNode1.right;
//        tempNode1.left = new TreeNode(6);
//        tempNode1.right = new TreeNode(7);

        System.out.println(chkIdentical(treeNode, treeNode1));

    }

}
