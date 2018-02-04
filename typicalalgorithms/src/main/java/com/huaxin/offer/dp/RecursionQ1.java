/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.dp;

/**
 * Description:
 * 实现递归式
 *
 * T(0) = T(1) = 2
 * T(n) = 2*T(1)*T(0) + 2*T(2)*T(1)+ ... + 2*T(n-1)*T(n-2)
 *
 * @author huaxin
 * @create 2018/01/31 19:55
 */
public class RecursionQ1 {

    /**
     * 直接采用递归的方式实现
     * @param n
     * @return
     */
    public static int solution1(int n) {
        int sum = 0;
        if (n == 0 || n == 1){
            return 2;
        }

        for (int i = 1; i < n; i++){
            sum += 2*solution1(i-1)*solution1(i);
        }

        return sum;
    }

    /**
     * 使用动态规划（备忘录）的方式实现
     *
     * 在计算T(n)的时候重复计算了很多值，使用备忘录可以将已经计算过的值直接进行使用
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 2;

        for (int i = 2; i <= n; i++){
            dp[i] = 0;
            for (int j = 1; j < i; j++) {
                dp[i] += 2*dp[j-1]*dp[j];
            }
        }

        return dp[n];
    }

    /**
     * 在上面的备忘录的方法的基础上，进行优化
     *
     * 其实不难发现:T(n) = T(n-1) + 2*T(n-1)*T(n-2),即所有的子问题仅仅依赖于前面的结果
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public static int solution3(int n) {
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 2;
        dp[2] = 2*dp[0]*dp[1];

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + 2*dp[i-1]*dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 8;
        long s1b = System.currentTimeMillis();
        int result = solution1(n);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - s1b);

        long s2b = System.currentTimeMillis();
        int result1 = solution2(n);
        System.out.println(result1);
        System.out.println(System.currentTimeMillis() - s2b);

        long s3b = System.currentTimeMillis();
        int result2 = solution3(n);
        System.out.println(result2);
        System.out.println(System.currentTimeMillis() - s3b);
    }
}
