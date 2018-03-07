/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

import java.util.ArrayList;

/**
 * Description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 *
 * 例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *
 * 则依次打印出数字:
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author huaxin
 * @create 2018/02/04 16:48
 */
public class PrintMatrix {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int x = 0, y = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println(rows+"  "+cols);
        while (list.size() < matrix.length * matrix[0].length) {
            list.addAll(print(matrix, x, y, rows, cols));
            x++;y++;rows--;cols--;
        }
        return list;
    }

    public static ArrayList<Integer> print(int [][] matrix, int indexX, int indexY, int rows, int cols){
        int i = indexX, j = indexY;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (j < cols) {
            list.add(matrix[i][j]);
            j++;
        }
        j--; i++;
        //如果只有一行的二维数组
        if (i >= rows) {
            return list;
        }
        while (i < rows) {
            list.add(matrix[i][j]);
            i++;
        }
        i--; j--;
        //如果只有一列的二维数组
        if (j < indexX) {
            return list;
        }
        while (j >= indexX) {
            list.add(matrix[i][j]);
            j--;
        }
        j++; i--;
        while (i > indexY) {
            list.add(matrix[i][j]);
            i--;
        }
        return list;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4}};
        ArrayList<Integer> list = printMatrix(matrix);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
