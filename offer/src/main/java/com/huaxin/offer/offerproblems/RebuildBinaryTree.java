/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 根据前序和中序重新构建二叉树
 *
 * @author huaxin
 * @create 2018/02/05 12:09
 */
public class RebuildBinaryTree {

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode rebuild(int [] pre, int l1, int r1, int [] in, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode node = new TreeNode(pre[l1]);
        int index = indexInArray(in, l2, r2, pre[l1]);
        node.left = rebuild(pre, l1+1, l1 + index - l2, in, l2,index - 1);
        node.right = rebuild(pre, l1 + index - l2 + 1, r1, in, index + 1, r2 );
        return node;
    }

    public static int indexInArray(int [] nums,int start, int end, int val){
        for (; start <= end; start++) {
            if (nums[start] == val) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        RebuildBinaryTree.reConstructBinaryTree(pre, in);
    }
}
