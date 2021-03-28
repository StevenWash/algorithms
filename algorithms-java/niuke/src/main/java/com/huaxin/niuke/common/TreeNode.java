/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.common;

/**
 * 自定义一个二叉树
 */
public class TreeNode {

    public TreeNode left;
    public TreeNode right;

    public int val;

    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(){

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "=" + left +
                ", right=" + right +
                ", value=" + val +
                '}';
    }
}
