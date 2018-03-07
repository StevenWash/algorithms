/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNode;

/**
 * Description:
 * 有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。
 * 树的结点个数小于等于500。
 *
 * @author huaxin
 * @create 2018/03/06 15:44
 */
public class CheckCompletion {

    /**
     * 判断一棵树是否是完全二叉树
     * @param root
     * @return
     */
    public static boolean chk(TreeNode root) {
        TreeNode[] queue = new TreeNode[20];
        int font = 0, rear = 0;

        if (root == null) {
            return true;
        }

        queue[rear++] = root;

        while (font != rear) {
            TreeNode node = queue[font++];
            if (node.right != null && node.left == null) {
                return false;
            }

            if (node.left != null && node.right != null) {
                queue[rear++] = node.left;
                queue[rear++] = node.right;
            }else  {
                // 此时说明当前节点之后的所有的节点必须均为叶子结点才是完全二叉树
                while (font != rear) {
                    node = queue[font++];
                    if (node.left != null || node.right != null) {
                        return false;
                    }
                }
            }
        }

        return true;
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
        //tempTree = tempTree.left;
       // tempTree.left = new TreeNode(8);
//        tempTree.right = new TreeNode(8);

        System.out.println(chk(treeNode));
    }

}
