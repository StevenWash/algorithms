/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.dp;

/**
 * Description:
 * 找零钱问题
 *
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 *
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 *
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 *
 * @author huaxin
 * @create 2018/03/07 19:09
 */
public class Exchange {

    public static int countWays(int[] penny, int n, int aim) {
        if (penny == null || penny.length <= 0 || aim < 0) {
            return 0;
        }

        int[][] map = new int[penny.length + 1][aim + 1];

//        return process1(penny, 0, aim, map);
        return process3(penny, aim);
    }

    public static int process1(int[] penny, int index, int aim, int[][] map) {
        int result = 0;

        if (index == penny.length) {
            if (aim == 0) {
                result = 1;
            }else {
                result = 0;
            }
        }else {
            int mapValue;
            for (int i = 0; penny[index]*i <= aim; i++) {
                mapValue = map[index+1][aim - penny[index]*i];

                if (mapValue != 0) {
                    result += mapValue == -1 ? 0 : mapValue;
                }else {
                    result += process1(penny, index+1, aim - penny[index]*i, map);
                }
            }

        }
        map[index][aim] = result == 0 ? -1 : result;
        return result;
    }

    public static int process2(int[] peney, int aim){
        int[][] note = new int[peney.length][aim+ 1];

        //初始化第一行
        for (int i = 0; i < aim + 1; i++) {
            if (i % peney[0] == 0) {
                note[0][i] = 1;
            }
        }

        for (int i = 1; i < peney.length; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j < peney[i]) {
                    note[i][j] = note[i-1][j];
                } else {
                    note[i][j] = note[i-1][j] + note[i][j - peney[i]];//关键
                }

            }
        }


        return note[peney.length-1][aim];
    }

    public static int process3(int[] peney, int aim){
        int [] note = new int[aim+ 1];
        note[0] = 1;

        for (int i = 0; i < peney.length; i++) {
            for (int j = peney[i]; j <= aim; j++) {
                note[j] += note[j - peney[i]];
            }
        }

        return note[aim];
    }

    public static void main(String[] args) {
        int [] penny = {1,2,4};
        System.out.println(countWays(penny, 3, 3));
    }

}
