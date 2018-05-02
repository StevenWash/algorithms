/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Description:
 * 非递归实现树的几种遍历
 *
 * @author huaxin
 * @create 2018/03/05 18:15
 */
public class TreeToSequence {

    public static int[][] convert(TreeNode root) {
        int[][] result;
        if (root == null) {
            return new int[][]{};
        }

        ArrayList list = new ArrayList();

        //先序遍历
        preOrder(root, list);
        result = new int[3][list.size()];
        result[0] = change(list);
        list.clear();

        midOrder(root, list);
        result[1] = change(list);
        list.clear();

        lastOrder2(root, list);
        result[2] = change(list);

        return result;
    }


    public static int[] change(ArrayList arrayList) {
        int []vals = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            vals[i] = (Integer) arrayList.get(i);
        }
        return vals;
    }

    /**
     * 非递归实现树的先序遍历
     *
     * 思路：
     *  1、先定义一个栈，将树根节点入栈
     *  2、然后遍历栈，当栈不为空的时候，栈顶元素出栈，访问该节点，
     *     如果该节点的左子树不为空则左子树入栈，如果右子树不为空则右子树入栈
     *
     * @param root
     * @param list
     */
    public static void preOrder(TreeNode root, ArrayList list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        stack.push(root);

        while (!stack.empty()) {
            node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left!= null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 非递归中序遍历
     *
     * 思路：
     *  1、先让头结点入栈，然后用node节点记录当前还未访问的节点
     *  2、循环遍历栈不为空，或者当前还有节点未访问，则将该节点入栈，并且将该节点的所有的左孩子节点入栈，直到当前的节点为NULL
     *     然后将当前栈顶的节点出栈，如果不为空则访问，并将该节点等于该节点的右孩子节点
     *
     * @param root
     * @param list
     */
    public static void midOrder(TreeNode root, ArrayList list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root.left;
        stack.push(root);

        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (node != null) {
                list.add(node.val);
                node = node.right;//因为是中序遍历，所以的那个访问完node节点之后，接下来没放问的就是node节点的右孩子
            }
        }
    }

    /**
     * 非递归遍历树的后序：只用一个栈实现
     * @param root
     * @param list
     */
    public static void lastOrder(TreeNode root, ArrayList list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root, top;
        stack.push(root);

        while (!stack.empty()) {
            top = stack.peek();
            if ((top.left != null && top.left != cur) && ((top.right != null && top.right != cur) || top.right == null)) {
                stack.push(top.left);
            }else if (top.right != null && top.right != cur) {
                stack.push(top.right);
            }else {
                cur = stack.pop();
                list.add(cur.val);
            }
        }
    }

    /**
     * 非递归遍历树的后序：只用一个栈实现
     * @param root
     * @param list
     */
    public static void lastOrder2(TreeNode root, ArrayList list) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        order(root, stack);
        while (!stack.empty()) {
            list.add(stack.pop().val);
        }
    }

    public static void order(TreeNode tree, Stack<TreeNode> stack) {
        if (tree == null) {
            return;
        }
        stack.push(tree);
        order(tree.right, stack);
        order(tree.left, stack);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(367);
        TreeNode tempTree = treeNode;
        tempTree.left = new TreeNode(415);
        tempTree.right = new TreeNode(415);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(65);
        tempTree.right = new TreeNode(316);
        tempTree = treeNode.right;
        tempTree.left = new TreeNode(245);
        tempTree.right = new TreeNode(142);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(84);
//        tempTree.right = new TreeNode(8);

        convert(treeNode);
    }


}
