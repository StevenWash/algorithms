/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise.huaxin4;

import java.util.Scanner;

/**
 * Description:
 * main
 *
 * @author huaxin
 * @create 2018/03/27 21:04
 */
public class Main {

    public static int solu(int n, int[][] arrs) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j != i && j < n; j++) {
                Trangle t1 = new Trangle(arrs[0][i], arrs[1][i], arrs[2][i], arrs[3][i]);
                Trangle t2 = new Trangle(arrs[0][j], arrs[1][j], arrs[2][j], arrs[3][j]);
                if (judge(t1, t2));{
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean judge(Trangle t1, Trangle t2) {

        if (!judge2(t1.x1,t1.y1, t2)) {
            return false;
        }
        if (!judge2(t1.x2,t1.y2, t2)) {
            return false;
        }
        if (!judge2(t1.x1,t1.y2, t2)) {
            return false;
        }
        if (!judge2(t1.x2,t1.y1, t2)) {
            return false;
        }

        return true;
    }

    public static boolean judge2(int x1, int y1, Trangle t) {
        if (x1 < t.x2 && y1 < t.y2 && x1 > t.x1 && y1 > t.y1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] arrs = new int[4][n];
        Scanner in1 = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String line = in1.nextLine();
            String[] lines = line.split(" ");
            for (int j = 0; j < n; j++) {
                arrs[i][j] = Integer.parseInt(lines[j]);
            }
        }

        System.out.println(solu(n, arrs));
    }
}

class Trangle{
    int x1,x2,y1,y2;

    Trangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}

