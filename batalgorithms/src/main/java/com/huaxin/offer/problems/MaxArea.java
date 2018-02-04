package com.huaxin.problems;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。
 * 现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。
 * 但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
 *
 * 輸入描述：
 * 首先输入一个正整数N三维坐标系内的点的个数.(N <= 50)
 * 接下来N行，每一行输入 c x y z，c为'R', 'G', 'B' 的其中一个。x，y，z是该点的坐标。(坐标均是0到999之间的整数)
 *
 * 输出描述：
 * 输出一个数表示最大的三角形面积，保留5位小数

 * 输入例子：
 * 5
 * R 0 0 0
 * R 0 4 0
 * R 0 0 3
 * G 92 14 7
 * G 12 16 8
 *
 * 输出例子：
 * 6.00000
 *
 *
 * 5
 * R 0 0 0
 * R 0 4 0
 * R 0 0 3
 * G 0 5 0
 * B 0 0 12
 *
 * 输出例子：
 * 30.00000
 *
 * @author 鑫
 *说明：本代码仅实现了三个点的颜色要么全部相同的计算方法，还没有完成要么全部不同的计算
 */
public class MaxArea {
    final static int NUMBER = 100;

    public static double findMaxNum(double[] nums) {
        double max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }

    public static double findMaxAre(int[][] nums, int cnt) {
        //System.out.println(cnt);

        double[] nums_1 = new double[NUMBER];
        int index = 0;
        double a = 0, b = 0, c = 0, p = 0, s = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt && j != i; j++) {
                for (int k = 0; k < cnt && k != i && k != j; k++) {
                    a = Math.sqrt((nums[i][0] - nums[j][0])
                            * (nums[i][0] - nums[j][0])
                            + (nums[i][1] - nums[j][1])
                            * (nums[i][1] - nums[j][1])
                            + (nums[i][2] - nums[j][2])
                            * (nums[i][2] - nums[j][2]));
                    b = Math.sqrt((nums[i][0] - nums[k][0])
                            * (nums[i][0] - nums[k][0])
                            + (nums[i][1] - nums[k][1])
                            * (nums[i][1] - nums[k][1])
                            + (nums[i][2] - nums[k][2])
                            * (nums[i][2] - nums[k][2]));
                    c = Math.sqrt((nums[k][0] - nums[j][0])
                            * (nums[k][0] - nums[j][0])
                            + (nums[k][1] - nums[j][1])
                            * (nums[k][1] - nums[j][1])
                            + (nums[k][2] - nums[j][2])
                            * (nums[k][2] - nums[j][2]));
                    if ((a + b) > c && (a + c) > b && (b + c) > a) {
                        p = (a + b + c) / 2;
                        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                        nums_1[index++] = s;
                        // System.out.println("a:"+a+" b:"+b+" c:"+c+" s:"+s);

                    }
                }
            }
        }

        return MaxArea.findMaxNum(nums_1);
    }

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        double[] nums_2 = new double[NUMBER];
        int index=0;
        int N ;
        String [][] src=null;

        // String[][] src = { { "" }, { "R", "0", "0", "0" },

        // { "R", "0", "4", "0" }, { "R", "0", "0", "3" },

        // { "G", "92", "14", "7" }, { "G", "12", "16", "8" } };


        N = sca.nextInt();
        src = new String[N+1][4];
        for (int i = 0; i < N + 1; i++) {
            src[i] = sca.nextLine().split(" ");
        }
        sca.close();

        int[][] redNums = new int[N][3];
        int[][] greNums = new int[N][3];
        int[][] bluNums = new int[N][3];
        int indexRed = 0, indexGre = 0, indexBlu = 0;
        for (int i = 1; i < N + 1; i++) {
            if (src[i][0].equals("R")) {
                redNums[indexRed][0] = Integer.parseInt(src[i][1]);
                redNums[indexRed][1] = Integer.parseInt(src[i][2]);
                redNums[indexRed][2] = Integer.parseInt(src[i][3]);
                indexRed++;
            } else if (src[i][0].equals("G")) {
                greNums[indexGre][0] = Integer.parseInt(src[i][1]);
                greNums[indexGre][1] = Integer.parseInt(src[i][2]);
                greNums[indexGre][2] = Integer.parseInt(src[i][3]);
                indexGre++;
            } else {
                bluNums[indexBlu][0] = Integer.parseInt(src[i][1]);
                bluNums[indexBlu][1] = Integer.parseInt(src[i][2]);
                bluNums[indexBlu][2] = Integer.parseInt(src[i][3]);
                indexBlu++;
            }
        }
        nums_2[index++]=MaxArea.findMaxAre(redNums, indexRed);
        nums_2[index++]=MaxArea.findMaxAre(greNums, indexGre);
        nums_2[index++]=MaxArea.findMaxAre(bluNums, indexBlu);
        DecimalFormat df = new DecimalFormat( "0.00000");
        System.out.println(df.format(MaxArea.findMaxNum(nums_2)));

    }

}