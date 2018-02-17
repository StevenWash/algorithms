/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author huaxin
 * @create 2018/02/09 17:04
 */
public class IsSymmetrical {

    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return judge(pRoot.left, pRoot.right);
    }

    /**
     *  判断两个子树是否相等：
     *    1、如果其中一个为null，另一个不为null则返回false
     *    2、如果两个子树的节点的值都不相等，则返回false
     *    3、如果两个子树都为空，则表示这两个子树是相等的，返回true
     *    4、然后递归检查子树p1Root的左子树和p2Root的右子树是否相等，同理
     *       p1Root的右子树和p2Root的左子树是否相等
     *
     * @param p1Root
     * @param p2Root
     * @return
     */
    public static boolean judge(TreeNode p1Root, TreeNode p2Root) {
        if (p1Root == null) {
            return p2Root == null;
        }
        if (p2Root == null) {
            return false;
        }
        if (p1Root.val != p2Root.val) {
            return false;
        }

        return judge(p1Root.left, p2Root.right) && judge(p1Root.right, p2Root.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);

        TreeNode leftTree = new TreeNode(6);
        TreeNode rightTree = new TreeNode(6);

        treeNode.left = leftTree;
        treeNode.right = rightTree;

        leftTree.left = new TreeNode(5);
        leftTree.right = new TreeNode(7);

        rightTree.left = new TreeNode(7);
        rightTree.right = new TreeNode(5);

        boolean result = isSymmetrical(treeNode);
        System.out.println(result);
    }
}
