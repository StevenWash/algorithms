/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;

import com.huaxin.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Description:
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * @author huaxin
 * @create 2018/02/04 19:59
 */
public class FindPath {
    public static ArrayList<ArrayList<Integer>>  paths = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> path = new ArrayList<Integer>();
    /**
     * 思路：
     *
     *
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        find(root, target);

        return paths;
    }

    public static ArrayList<Integer> find(TreeNode tree, int target){

        if (tree.val == target) {
            path.add(tree.val);
            paths.add(path);
            path = new ArrayList<Integer>();
        }

        if (tree.val < target) {
            path.add(tree.val);
            target -= tree.val;

            if (tree.left != null) {
                path.addAll(find(tree.left, target));
                if (path.size()>0) {
                    path.remove(path.size()-1);
                }
            }

            if (tree.right != null) {
                path.addAll(find(tree.right, target));
                if (path.size()>0) {
                    path.remove(path.size()-1);
                }
            }

        }

        return new ArrayList<Integer>();
    }

    static class Test{
        int a = 0;
        int b = 3;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);

        TreeNode leftTree = new TreeNode(5);
        TreeNode rightTree = new TreeNode(12);

        treeNode.left = leftTree;
        treeNode.right = rightTree;

        leftTree.left = new TreeNode(4);
        leftTree.right = new TreeNode(7);

//        rightTree.left = new TreeNode(9);
//        rightTree.right = new TreeNode(11);

        FindPath(treeNode, 22);
    }

}
