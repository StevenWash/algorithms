/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author huaxin
 * @create 2018/02/09 15:16
 */
public class PrintTreeByLevel {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return levels;
        }
        ArrayList<Integer> level = new ArrayList<Integer>();
        TreeNode treeNode;
        int last, nlast = 0 ;
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.add(pRoot);

        last = pRoot.val;
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            level.add(treeNode.val);

            if (treeNode.left != null)  {
                queue.add(treeNode.left);
                nlast = treeNode.left.val;
            }
            if (treeNode.right != null)  {
                queue.add(treeNode.right);
                nlast = treeNode.right.val;
            }

            if (last == treeNode.val) {
                levels.add(level);
                level = new ArrayList<Integer>();
                last = nlast;
            }
        }

        return levels;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);

        TreeNode leftTree = new TreeNode(6);
        TreeNode rightTree = new TreeNode(10);

        treeNode.left = leftTree;
        treeNode.right = rightTree;

        leftTree.left = new TreeNode(5);
        leftTree.right = new TreeNode(7);

        rightTree.left = new TreeNode(9);
        rightTree.right = new TreeNode(11);

        Print(treeNode);
    }

}
