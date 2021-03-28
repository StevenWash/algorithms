/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * Description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author huaxin
 * @create 2018/02/04 18:55
 */
public class IsPopOrder {

    /**
     * 思路：
     * 1、首先，将压入序列第一个元素入栈
     * 2、判断此时栈顶的元素和出栈的第一个元素值是否一样，若一样，则栈顶元素出栈，若不一样，
     *   则判断当前输入的序列是否都已入栈，如果都已入栈，则返回false,否则，将接下来的元素入栈
     * 3、接着比较出栈序列的下一个元素和当前的栈顶元素，重复2
     * 4、如果当前出栈的元素的都比较完了，则返回true
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int indexA = 0, indexB = 0;
        int []stack = new int[popA.length];
        int index = 0;

        stack[index++] = pushA[indexA++];
        while (indexB < popA.length) {
            if (stack[index-1] == popA[indexB]) {
                index--;indexB++;
            }else {
                if (indexA == pushA.length) {
                    return false;
                }else {
                    stack[index++] = pushA[indexA++];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int [] pushA = {1,2,3,4,5};
        int [] popA = {4,3,5,1,2};
        boolean result = IsPopOrder(pushA, popA);
        System.out.println(result);
    }

}
