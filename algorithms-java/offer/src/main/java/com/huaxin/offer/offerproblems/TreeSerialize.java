/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import com.huaxin.offer.common.TreeNode;
import sun.security.krb5.internal.crypto.Des;

/**
 * Description:
 * 先序遍历的方式序列化一棵二叉树
 *
 * @author huaxin
 * @create 2018/03/05 20:23
 */
public class TreeSerialize {
    static int index = 0;
    /**
     * 将一棵树进行先序遍历的序列化
     *
     * @param root
     * @return
     */
    public static String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            return "#!";
        }else {
            stringBuilder.append(root.val+"!");
        }

        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));

        return stringBuilder.toString();
    }

    /**
     *  针对上面的序列化的结果进行反序列化的操作
     * @param str
     * @return
     */
    public static TreeNode Deserialize(String str) {
        if (str == null || str.length() <= 0){
            return null;
        }

        String[] values = str.split("!");
        if (values[index].equals("#")) {
            index ++;
            return null;
        }
        TreeNode tree = new TreeNode(Integer.parseInt(values[index++]));

        tree.left = Deserialize(str);
        tree.right = Deserialize(str);

        return tree;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode tempTree = treeNode;

        tempTree.left = new TreeNode(2);
        tempTree.right = new TreeNode(3);

        tempTree = tempTree.left;

        tempTree.left = new TreeNode(4);
        tempTree.right = new TreeNode(5);

        tempTree = treeNode.right;
        tempTree.left = new TreeNode(6);
        tempTree.right = new TreeNode(7);

        tempTree = tempTree.left;
        tempTree.left = new TreeNode(8);
//        tempTree.right = new TreeNode(9);

        String result = Serialize(treeNode);
        System.out.println(result);

        TreeNode treeNode1 = Deserialize(result);
    }

}
