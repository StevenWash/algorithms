/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import apple.laf.JRSUIUtils;
import com.huaxin.niuke.common.TreeNode;

import java.util.ArrayList;

/**
 * Description:
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点并返回他们的值。
 * 保证二叉树中结点的值各不相同。  给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 *
 * @author huaxin
 * @create 2018/03/06 16:29
 */
public class FindErrorNode {

    /**
     * 找到一棵搜索二叉树中的错误节点
     *
     * 思路：
     *  1、先用中序遍历得到二叉树的遍历序列集合（如果都是顺序增序则依旧是二叉搜索树）
     *  2、然后循环遍历的到的集合，判断连续的两个数如果是降序，则将较大的作为第一个元素存在first中，并记录降序次数cnt
     *  3、如果cnt大于则将之后的降序中较小的一个存在last中，first不用变
     *
     * @param root
     * @return
     */
    public static int[] findError(TreeNode root) {
        int [] result = new int[2];
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(root == null) {
            return result;
        }

        travle(root, list);

        int cnt = 0;
        int first = 0, last = 0, cur, before = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            cur = list.get(i);
            if (cur < before) {
                cnt++;
                if (cnt <= 1) {
                    first = before;
                }
                last = cur;
            }
            before = cur;
        }
        result[0] = first > last ? last : first;
        result[1] = first < last ? last : first;
        return result;
    }

    public static void travle(TreeNode treeNode, ArrayList list) {
        if (treeNode == null) {
            return;
        }

        travle(treeNode.left, list);
        list.add(treeNode.val);
        travle(treeNode.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);

        TreeNode tempTree = treeNode;
        tempTree.left = new TreeNode(5);
        tempTree.right = new TreeNode(6);
        tempTree = tempTree.left;

        tempTree.left = new TreeNode(1);
        tempTree.right = new TreeNode(3);
        tempTree = treeNode.right;
        tempTree.left = new TreeNode(2);
        tempTree.right = new TreeNode(7);
        //tempTree = tempTree.left;
        // tempTree.left = new TreeNode(8);
//        tempTree.right = new TreeNode(8);

        System.out.println(findError(treeNode)[0]+"  "+findError(treeNode)[1]);
    }
}
