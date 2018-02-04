package com.huaxin.binarytree;

import com.huaxin.common.MyBinaryTree;

/**
 * 二叉树的序列化和反序列化
 *
 * 以先序遍历为例
 */
public class BinaryTreeSequence {
    /**
     * 全局定位器
     */
    static int index = 0;

    /**
     * 将一棵二叉树通过先序遍历的方式进行序列化为一个字符串
     * @param binaryTree
     * @return 序列化之后的字符串
     */
    public static String encodeToString(MyBinaryTree binaryTree) {
        StringBuffer str = new StringBuffer();
        if (binaryTree!=null) {
            str.append(binaryTree.value+"!");
        }else {
            return "#!";
        }

        str.append(encodeToString(binaryTree.leftChild));
        str.append(encodeToString(binaryTree.rightChild));

        return str.toString();
    }

    /**
     * 将一个序列化之后的二叉树进行反序列化，重新生成一棵二叉树
     * @param treeStr
     * @return
     */
    public static MyBinaryTree decodeToBinaryTree(String treeStr) {
        String splitStr = "#";
        if (index > treeStr.length()) {
            index = 0;
        }
        if (treeStr == null || treeStr.length()<=0) {
            return null;
        }
        String[] values = treeStr.split("!");
        if (splitStr.equals(values[index])) {
            index++;
            return null;
        }
        MyBinaryTree binaryTree = new MyBinaryTree(Integer.parseInt(values[index]));
        index++;
        binaryTree.leftChild = decodeToBinaryTree(treeStr);
        binaryTree.rightChild = decodeToBinaryTree(treeStr);

        return binaryTree;
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

        String str = encodeToString(myBinaryTree);

        System.out.println(str);

        System.out.println(encodeToString(decodeToBinaryTree(str)));
    }



}
