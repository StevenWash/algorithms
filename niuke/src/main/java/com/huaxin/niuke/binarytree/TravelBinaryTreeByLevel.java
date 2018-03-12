/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNode;

import java.util.ArrayList;

/**
 * 按层次遍历二叉树
 */
public class TravelBinaryTreeByLevel {

    /**
     * 变量说明：
     * font:是队列queue的队首指针
     * rear:是队列queue的队尾指针
     * last:记录当前行的最后一个节点
     * nlast:记录下一行的最后一个节点
     * @param binaryTree
     */
    public static void travel(TreeNode binaryTree) {
        TreeNode[] queue = new TreeNode[20];
        int font=0, rear=0;
        TreeNode last, nlast = null;
        last = binaryTree;
        queue[rear++] = binaryTree;

        while(font!=rear) {
            TreeNode temp = queue[font++];
            System.out.print(temp.val);

            if(temp.left != null) {
                queue[rear++] = temp.left;
                nlast = temp.left;
            }
            if(temp.right != null) {
                queue[rear++] = temp.right;
                nlast = temp.right;
            }
            /**
             * 此时说明遍历的结点已经到了当前层的最右边结点
             * 1、先换行，便是当前行结束
             * 2、然后姜当前的last修改为下一行的最后边的节点
             */
            if (temp.val == last.val) {
                System.out.println();
                last = nlast;
            }
        }
    }

    /**
     * 将一棵二叉树以层次遍历的方式，将每行的结果存在数组中并返回
     * @param root
     * @return
     */
    public static int[][] printTree(TreeNode root) {
        // write code here
        //int[][] nodes = new int [8][8];
        TreeNode[] queue = new TreeNode[500];
        TreeNode last, nlast = null;

        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int font = 0, rear = 0;
        last = root;
        queue[rear++] = root;

        while(font!=rear) {
            TreeNode temp = queue[font++];
            list.add(temp.val);
            if(temp.left != null){
                queue[rear++] = temp.left;
                nlast = temp.left;
            }
            if(temp.right != null){
                queue[rear++] = temp.right;
                nlast = temp.right;
            }
            if(last.val == temp.val) {
                lists.add(list);
                list = new ArrayList<Integer>();
                last = nlast;
            }
        }

        int [][] nodes = new int[lists.size()][] ;
        for (int i = 0; i < lists.size(); i++) {
            nodes[i] = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) {
                nodes[i][j] = lists.get(i).get(j);
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode tempTree = treeNode;
        tempTree.left = new TreeNode(2);
        tempTree.right = new TreeNode(3);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(4);
        tempTree = treeNode.right;
        tempTree.left = new TreeNode(5);
        tempTree.right = new TreeNode(6);
        tempTree = tempTree.left;
        tempTree.left = new TreeNode(7);
        tempTree.right = new TreeNode(8);

        travel(treeNode);

        int [][] a=printTree(treeNode);

    }
}
