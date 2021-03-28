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

    public static void find(TreeNode tree, int target){

        if (tree == null ){
            return;
        }

        path.add(tree.val);
        if (tree.val == target && tree.left == null && tree.right == null) {


            ArrayList list = new ArrayList();

            for (int i = 0; i < path.size(); i++) {
                list.add(path.get(i));
            }

            paths.add(list);
            return ;
        }

        if (tree.val < target) {
            find(tree.left, target - tree.val);
            if (tree.left != null) {
                path.remove(new Integer(tree.left.val));
            }

            find(tree.right, target - tree.val);
            if (tree.right != null) {
                path.remove(new Integer(tree.right.val));
            }
        }
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

        FindPath(treeNode, 15);
    }

}
