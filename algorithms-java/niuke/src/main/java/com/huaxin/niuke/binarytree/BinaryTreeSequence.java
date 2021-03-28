/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNode;

/**
 * 二叉树的序列化和反序列化
 *
 * 以先序遍历为例
 */
public class BinaryTreeSequence {
    /**
     * 全局定位器
     */
    static int index = 0;

    /**
     * 将一棵二叉树通过先序遍历的方式进行序列化为一个字符串
     *
     * 思路：
     *   1、首先规定用特殊字符"!" 表示一个数的结束，用特殊字符"#!"表示一个空值结束
     *   2、先序遍历二叉树，如节点为空则在字符串的末尾加上"#!"，否则就是节点值+"!"
     *   3、然后递归调用
     *
     * @param binaryTree
     * @return 序列化之后的字符串
     */
    public static String encodeToString(TreeNode binaryTree) {
        StringBuffer str = new StringBuffer();
        if (binaryTree!=null) {
            str.append(binaryTree.val+"!");
        }else {
            return "#!";
        }

        str.append(encodeToString(binaryTree.left));
        str.append(encodeToString(binaryTree.right));

        return str.toString();
    }

    /**
     * 将一个序列化之后的二叉树进行反序列化，重新生成一棵二叉树
     * @param treeStr
     * @return
     */
    public static TreeNode decodeToBinaryTree(String treeStr) {
        String splitStr = "#";
        if (index > treeStr.length()) {
            index = 0;
        }
        if (treeStr == null || treeStr.length()<=0) {
            return null;
        }
        String[] values = treeStr.split("!");
        if (splitStr.equals(values[index])) {
            index++;
            return null;
        }
        TreeNode binaryTree = new TreeNode(Integer.parseInt(values[index]));
        index++;
        binaryTree.left = decodeToBinaryTree(treeStr);
        binaryTree.right = decodeToBinaryTree(treeStr);

        return binaryTree;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode tempTree = treeNode;
        tempTree.left = new TreeNode(2);
        tempTree.right = new TreeNode(3);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(4);
        tempTree = treeNode.right;
        tempTree.left = new TreeNode(5);
        tempTree.right = new TreeNode(6);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(7);
        tempTree.right = new TreeNode(8);

        String str = encodeToString(treeNode);

        System.out.println(str);

        System.out.println(encodeToString(decodeToBinaryTree(str)));
    }



}
