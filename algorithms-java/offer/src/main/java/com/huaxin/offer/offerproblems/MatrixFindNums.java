/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * 题目：在一个二维数组中，每一行从左到右递增，每一列从上到下递增，
 * 完成一个函数，输入一个二维数组和一个数，查找该二维数组中是否存在该数
 * 若存在返回该数在数组中的位
 * 不存在给出提示
 * @author 鑫
 *
 */
public class MatrixFindNums {
    private static int[] index=new int[2];

    public static boolean find(int [][]matris,int number){
        int row=0,rows = matris.length,colum =matris[0].length - 1;
        while(matris!=null&&row<rows&&colum>=0){
            if(matris[row][colum]==number){
                index[0]=row;
                index[1]=colum;
                return true;
            }else if(matris[row][colum]>number){
                colum--;
            }else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str="hello world!welcome to Wuhan!";

        System.out.println(str.replace(" ", ""));

        int[][]matris={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        //int [][]matris = null;

        int num=2;
        if(MatrixFindNums.find(matris, num)){
            System.out.println("查找的数是："+num+"   位置在：["+index[0]+","+index[1]+"]");
        }else {
            System.out.println("查找的数是："+num+"  该数不存在");
        }
    }

}
