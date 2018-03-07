/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.common;

/**
 * Description:
 * TreeNode
 *
 * @author huaxin
 * @create 2018/02/05 12:08
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode() { val = 0; }
    public TreeNode(TreeNode f) {
        val = f.val;
        left = f.left;
        right = f.right;
    }
}
