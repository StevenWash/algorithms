package com.huaxin.binarytree;

import com.huaxin.common.MyBinaryTree;

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
    public static void travel(MyBinaryTree binaryTree) {
        MyBinaryTree [] queue = new MyBinaryTree[20];
        int font=0, rear=0;
        MyBinaryTree last, nlast = null;
        last = binaryTree;
        queue[rear++] = binaryTree;

        while(font!=rear) {
            MyBinaryTree temp = queue[font++];
            System.out.print(temp.value);

            if(temp.leftChild != null) {
                queue[rear++] = temp.leftChild;
                nlast = temp.leftChild;
            }
            if(temp.rightChild != null) {
                queue[rear++] = temp.rightChild;
                nlast = temp.rightChild;
            }
            /**
             * 此时说明遍历的结点已经到了当前层的最右边结点
             * 1、先换行，便是当前行结束
             * 2、然后姜当前的last修改为下一行的最后边的节点
             */
            if (temp.value == last.value) {
                System.out.println();
                last = nlast;
            }
        }
    }

    /**
     * 将一棵二叉树以层次遍历的儿方式，将每行的结果存在数组中并返回
     * @param root
     * @return
     */
    public static int[][] printTree(MyBinaryTree root) {
        // write code here
        //int[][] nodes = new int [8][8];
        MyBinaryTree[] queue = new MyBinaryTree[500];
        MyBinaryTree last, nlast = null;

        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int font = 0, rear = 0;
        last = root;
        queue[rear++] = root;

        while(font!=rear) {
            MyBinaryTree temp = queue[font++];
            list.add(temp.value);
            if(temp.leftChild != null){
                queue[rear++] = temp.leftChild;
                nlast = temp.leftChild;
            }
            if(temp.rightChild != null){
                queue[rear++] = temp.rightChild;
                nlast = temp.rightChild;
            }
            if(last.value == temp.value) {
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
        MyBinaryTree myBinaryTree = new MyBinaryTree(1);
        MyBinaryTree tempTree = myBinaryTree;
        tempTree.leftChild = new MyBinaryTree(2);
        tempTree.rightChild = new MyBinaryTree(3);
        tempTree = tempTree.leftChild;
        tempTree.leftChild = new MyBinaryTree(4);
        tempTree = myBinaryTree.rightChild;
        tempTree.leftChild = new MyBinaryTree(5);
        tempTree.rightChild = new MyBinaryTree(6);
        tempTree = tempTree.leftChild;
        tempTree.leftChild = new MyBinaryTree(7);
        tempTree.rightChild = new MyBinaryTree(8);

        travel(myBinaryTree);

        int [][] a=printTree(myBinaryTree);

    }
}
