/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Description:
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author huaxin
 * @create 2018/03/06 21:31
 */
public class PrintWithZ {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        travel1(pRoot, paths);

        for (int i = 1; i <= paths.size(); i++) {
            if (i % 2 == 0) {
                ArrayList list = paths.get(i-1);
                reverse(list);
                paths.set(i-1, list);
            }
        }

        return paths;
    }

    public static void reverse(ArrayList<Integer> list) {
        int[] stack = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            stack[index++] = i;
        }
        list.clear();
        index--;
        while (index >= 0 ) {
            list.add(stack[index--]);
        }
    }

    public static void travel1(TreeNode pRoot, ArrayList<ArrayList<Integer>> paths) {
        if (pRoot == null) {
            return;
        }
        TreeNode last, nlast, node;
        ArrayList<Integer> path = new ArrayList<Integer>();
        TreeNode[] queue = new TreeNode[20];
        int font = 0, rear = 0;

        queue[rear++] = pRoot;
        last = pRoot;
        nlast = pRoot;

        while (font != rear) {
            node = queue[font++];
            path.add(node.val);
            System.out.print(node.val);

            if (node.left != null) {
                queue[rear++] = node.left;
                nlast = node.left;
            }
            if (node.right != null) {
                queue[rear++] = node.right;
                nlast = node.right;
            }
            if (last == node) {
                paths.add(path);
                last = nlast;
                path = new ArrayList<Integer>();
                System.out.println();
            }

        }
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
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        Print(treeNode);
    }

}
