/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.common;

/**
 * 自定义一个二叉树
 */
public class MyBinaryTree {

    public MyBinaryTree leftChild;
    public MyBinaryTree rightChild;

    public int value;

    public MyBinaryTree(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", value=" + value +
                '}';
    }
}
