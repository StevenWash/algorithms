/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNodeWithParent;

/**
 * Description:
 * 给出一棵树中的任意一个节点，给出以中序遍历的情况下该节点的后继节点
 *
 * @author huaxin
 * @create 2018/03/05 19:46
 */
public class NextNode {

    public static TreeNodeWithParent nextNode(TreeNodeWithParent node) {
        if (node == null) {
            return null;
        }

        TreeNodeWithParent p, s;
        p = node.parent;
        s = node;

        if (s.right != null) {
            s = s.right;
            while (s.left != null) {
                s = s.left;
            }
            return s;
        }
        if (p != null && p.left == s) {
            return p;
        }
        while (p != null) {
            s = p;
            p = p.parent;

            if (p != null && p.left == s) {
                return p;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNodeWithParent parent = new TreeNodeWithParent();
        parent.val = 8;
        parent.parent = null;


        TreeNodeWithParent left = new TreeNodeWithParent();
        left.val = 6;
        left.parent = parent;


        TreeNodeWithParent left1 = new TreeNodeWithParent();
        left1.val = 5;
        left1.parent = left;

        TreeNodeWithParent right1 = new TreeNodeWithParent();
        right1.val = 7;
        right1.parent = left;

        left.left = left1;
        left.right = right1;

        TreeNodeWithParent right = new TreeNodeWithParent();
        right.val = 10;
        right.parent = parent;

        TreeNodeWithParent left2 = new TreeNodeWithParent();
        left2.val = 9;
        left2.parent = right;

        TreeNodeWithParent right2 = new TreeNodeWithParent();
        right2.val = 11;
        right2.parent = right;

        right.left = left2;
        right.right = right2;

        parent.left = left;
        parent.right = right;

        TreeNodeWithParent nodeWithParent = nextNode(parent);
        System.out.println(nodeWithParent);
    }
}