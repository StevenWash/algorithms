/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.typical.exercise;

import java.util.*;

/**
 * Description:
 * 订单最优分配
 *
 * @author huaxin
 * @create 2018/03/11 10:37
 */
public class BookAssign {

    /**
     * 思路：
     *  把order中的每一个值当做数值匹配中的target
     *
     * @param order
     * @param boms
     * @return
     */
    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        Map<String, List<Integer>> results = new HashMap<String, List<Integer>>();
        List<Integer> bom;



        // 用来存放当前剩下的商品的数量
        int[] target = new int[order.size()];


        //表示起始匹配的组合
        for (int k = 0; k < boms.size(); k++) {
            //每进行一次匹配都会将target数组更新为当前的order的值
            for (int i = 0; i < order.size(); i++) {
                target[i] = order.get(i);
            }

            boolean endF = true;
            boolean flag = true;
            int[] count = new int[order.size()];
            // 每次的匹配从第k个组合开始，相当于以第k个优先
            for (int j = k; endF && j < boms.size();) {
                endF = true;
                bom = boms.get("bom"+(k+1));
                //判断是不是所有的剩下商品的数量都大于当前的bom的每一项商品数量
                for (int i = 0; i < bom.size(); i++) {
                    if (target[i] < bom.get(i)) {
                        flag = false;
                    }
                }

                if (flag) {
                    for (int i = 0; i < bom.size(); i++) {
                        target[i] = target[i] - bom.get(i);
                    }
                    count[j]++;
                }else {
                    //只有当前的剩下的商品数量不能再满足当前的组合中要求的商品数量时，才进行判断下一个组合
                    //并且j的增加值是循环的：从k开始，一直到boms.size()-1，然后再到0,接着到k-1
                    j++;
                    if (j == boms.size()) {

                        if (k == 0) {
                            endF = false;
                        }else {
                            j = j % boms.size();
                            if (j <= k-1) {
                                continue;
                            }else {
                                endF = false;
                            }
                        }
                    }
                }
            }

            ArrayList re = new ArrayList();

            for (int j = 0; j < target.length; j++) {
                re.add(target[j]);
            }

            results.put("bom"+k, re);
        }

        //比较哪一个组合最符合题目中的要求


        return result;
    }

    public static void main(String[] args) {

        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for(int i = 0; i < n ; i++){
            order.add(Integer.parseInt(itemCnt[i]));
        }

        for(int i = 0; i < m; i++){
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for(int j = 1; j <= n; j++ ){
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();

        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }
}
