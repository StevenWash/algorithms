/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.common;

import javax.swing.event.TreeWillExpandListener;

/**
 * Description:
 * 带有指向父节点的指针
 *
 * @author huaxin
 * @create 2018/03/05 19:44
 */
public class TreeNodeWithParent {
    public TreeNodeWithParent left;
    public TreeNodeWithParent right;
    public TreeNodeWithParent parent;
    public int val;

    @Override
    public String toString() {
        return "TreeNodeWithParent{val=" + val +
                '}';
    }
}
