/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNode;

import java.util.ArrayList;

/**
 * Description:
 * 递归实现树的前、中、后序遍历
 *
 * @author huaxin
 * @create 2018/03/05 16:58
 */
public class TreeToSequenceByRecur {
    public static int[][] convert(TreeNode root) {
        int[][] result;
        if (root == null) {
            return new int[][]{};
        }

        ArrayList list = new ArrayList();

        //先序遍历
        preOrder(root, list);
        result = new int[3][list.size()];
        result[0] = change(list);
        list.clear();

        midOrder(root, list);
        result[1] = change(list);
        list.clear();

        lastOrder(root, list);
        result[2] = change(list);

        return result;
    }

    public static int[] change(ArrayList arrayList) {
        int []vals = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            vals[i] = (Integer) arrayList.get(i);
        }
        return vals;
    }

    public static void preOrder(TreeNode root, ArrayList list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        //result[0][index1++] = root.value;
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public static void midOrder(TreeNode root, ArrayList list) {
        if (root == null) {
            return;
        }

        midOrder(root.left, list);
//        result[1][index2++] = root.value;
        list.add(root.val);
        midOrder(root.right, list);
    }

    public static void lastOrder(TreeNode root, ArrayList list) {
        if (root == null) {
            return;
        }

        lastOrder(root.left, list);
        lastOrder(root.right, list);
//        result[2][index3++] = root.value;
        list.add(root.val);
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

        convert(treeNode);
    }
}
