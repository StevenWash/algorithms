/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems.unpass;

import com.huaxin.offer.common.TreeNode;

/**
 * Description:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author huaxin
 * @create 2018/02/05 19:50
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }


        if (root1.val != root2.val) {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }else {
            TreeNode t1 = root1,t2 = root2;
            while (t1 != null && t2 != null) {
                if (t1.val != t2.val) {
                    break;
                }
                t2 = t2.left;
                t1 = t1.left;
            }
            if(t2 != null){
                return false;
            }
            t1 = root1;t2 = root2;
            while (t1 != null && t2 != null) {
                if (t1.val != t2.val) {
                    return false;
                }
                t2 = t2.right;
                t1 = t1.right;
            }

            if (t2 != null ) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

    }
}
