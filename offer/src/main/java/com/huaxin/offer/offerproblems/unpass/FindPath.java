/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;

import com.huaxin.offer.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Description:
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * @author huaxin
 * @create 2018/02/04 19:59
 */
public class FindPath {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();

        TreeNode treeNode;
        int sum = 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            treeNode = stack.pop();
            sum +=treeNode.val;
            path.add(treeNode.val);



        }

        return paths;
    }

}
