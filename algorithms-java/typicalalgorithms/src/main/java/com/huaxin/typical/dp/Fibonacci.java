/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.dp;

/**
 * Description:
 * 动态规划实现斐波那契数列
 * [1,1,2,3,5,8,13,21,34,55,89,144...]
 *
 * 总结：
 *   1、如何基于子问题对原始问题进行递归定义
 *   2、是否能够使用备忘录避免重复计算（即子问题的值是否有叠加）
 *
 * @author huaxin
 * @create 2018/01/29 20:16
 */
public class Fibonacci {
    static int  fib[] = new int[1024];

    /**
     * 通过普通递归的方式进行实现
     * 时间复杂度：O(2^n)
     * @param n 求解数
     * @return
     */
    public static int solution1(int n){
        if ( n == 0 || n == 1) {
            return 1;
        }
        return solution1(n-1) + solution1(n-2);
    }

    /**
     * 采用备忘录进行记录已经计算了值
     *
     * 自底向上：由两个最小的参数开始进行计算，逐步向上递推进行计算
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public static int solution2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        fib[0] = fib[1] = 1;
        for (int i = 2; i <= n; i++){
           fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    /**
     * 采用备忘录进行记录已经计算了值
     *
     * 自顶向下：由计算n需要n-1和n-2来进行向下递归，并结合使用备忘录，如果计算过了的值
     *   则直接返回
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public static int solution2_1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (fib[n] != 0) {
            return fib[n];
        }

        return fib[n] = fib[n - 1] + fib[ n - 2];
    }

    /**
     * 进一步进行改进,思路就是每次n的值至于前面的n-1和n-2相关，所以只需要保存前面的两个值即可
     * 时间复杂度为：O(n)
     * 空间复杂度为：O(1)
     * @param n
     * @return
     */
    public static int solution3(int n) {
        int a = 1;
        int b = 1;
        int sum = 1;

        for (int i = 2; i <= n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 40;
        long s1b = System.currentTimeMillis();
        int result = solution1(n);
        System.out.println("s1-end:"+ (System.currentTimeMillis() - s1b));
        System.out.println(result+"\n");

        long s2b = System.currentTimeMillis();
        int result1 = solution2(n);
        System.out.println("s2-end:"+(System.currentTimeMillis() - s2b));
        System.out.println(result1+"\n");

        long s2_1b = System.currentTimeMillis();
        int result1_1 = solution2_1(n);
        System.out.println("s2_1-end:"+(System.currentTimeMillis() - s2_1b));
        System.out.println(result1_1+"\n");

        long s3b = System.currentTimeMillis();
        int result2 = solution3(n);
        System.out.println("s3-end:"+(System.currentTimeMillis() - s3b));
        System.out.println(result2+"\n");
    }
}
