/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 *
 * @author huaxin
 * @create 2018/03/06 20:51
 */
public class KthNode {

    public static int index = 1;
    public static TreeNode result;

    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return result;
        }
        travel(pRoot, k);
        return result;
    }

    public static void travel(TreeNode tree, int k) {
        if (tree == null) {
            return;
        }

        travel(tree.left, k);
        if (index == k) {
            result = tree;
        }
        index++;
        travel(tree.right, k);
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

        System.out.println(KthNode(treeNode, 1).val);
    }

}
