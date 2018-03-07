/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.binarytree;

import com.huaxin.niuke.common.TreeNode;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。
 * 此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；
 * 突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。
 * 请从上到下计算出所有折痕的⽅向。  给定折的次数n,请返回从上到下的折痕的数组，
 * 若为下折痕则对应元素为"down",若为上折痕则为"up".
 *
 * @author huaxin
 * @create 2018/03/06 20:02
 */
public class FoldPaper {

    public static String[] foldPaper(int n) {
        TreeNode treeNode = createTree(n, 0);
        ArrayList list = new ArrayList();
        travel(treeNode, list);

        String []result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if ((Integer)list.get(i) == 0) {
                result[i] = "down";
            } else {
                result[i] = "up";
            }
        }

        return result;
    }

    public static TreeNode createTree( int n, int i) {
        TreeNode root = null;
        if (n > 0) {
            root = new TreeNode(i);
            root.left = createTree( n-1, 0);
            root.right = createTree(n-1, 1);
        }
        return root;
    }

    public static void travel(TreeNode tree, ArrayList list) {
        if (tree == null) {
            return;
        }

        travel(tree.left, list);
        list.add(tree.val);
        travel(tree.right, list);
    }

    public static void main(String[] args) {
        foldPaper(3);
    }

}
