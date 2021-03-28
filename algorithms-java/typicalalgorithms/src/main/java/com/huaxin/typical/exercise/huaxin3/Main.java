/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise.huaxin3;

import java.util.Scanner;

/**
 * Description:
 * main
 *
 * @author huaxin
 * @create 2018/03/27 20:39
 */
public class Main {
    public static int solu(int n, int k) {
        int result = 0;
        for (int i = k; i <= n; i++) {
            for (int j = 0; j < Math.abs(i-n); j++) {
                result++;
            }

        }

        for (int i = k+1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (j%i >= k) {
                    result++;
                }
            }

        }


        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String [] lines = line.split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);
        System.out.println(solu(n, k));
    }

}
