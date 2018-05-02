/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise.huaxin1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description:
 * main
 *
 * @author huaxin
 * @create 2018/03/24 19:01
 */
public class Main {

    public static int solu(int [] arrs, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (k == 0) {
            return 1;
        }
        for (int i = 0; i < arrs.length; i++) {
            list.add(arrs[i]);
        }
        int [] hash = new int[1000000];
        for (int i = 0; i < list.size(); i++) {
            if (hash[list.get(i)] == 1) {
                list.remove(i);
            }else {
                hash[list.get(i)] = 1;
            }
        }
        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    if (list.get(i) - list.get(j) == k) {
                        list1.add(list.get(i));
                        list2.add(list.get(j));
                    }
                }
            }
        }

        return list1.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] line1s = line1.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int k = Integer.parseInt(line1s[1]);
        int [] arrs = new int[n];
        String line2 = sc.nextLine();
        String [] line2s = line2.split(" ");
        for(int i = 0; i < n; i++){
            arrs[i] = Integer.parseInt(line2s[i]);
        }

        System.out.println(solu(arrs, k));

    }

}
