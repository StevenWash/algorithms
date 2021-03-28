/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

import java.util.ArrayList;

/**
 * Description:
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author huaxin
 * @create 2018/02/04 18:58
 */
public class PrintFromTopToBottom {

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        TreeNode[] queue = new TreeNode[50];
        int rear = 0,font = 0;


        queue[rear++] = root;

        while (rear != font) {
            TreeNode node = queue[font++];
            result.add(node.val);
            if (node.left !=null) {
                queue[rear++] = node.left;
            }
            if (node.right != null) {
                queue[rear++] = node.right;
            }
        }

        return result;
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

        ArrayList<Integer> result = PrintFromTopToBottom(treeNode);
        System.out.println(result);
    }

}
