/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。
 * 保证A中字符全部为小写英文字符，且长度小于等于500。
 *
 * 测试样例： "aabcb",5
 * 返回：3
 *
 * @author huaxin
 * @create 2018/03/12 23:12
 */
public class DistinctSubstring {

    /**
     * 思路：
     * 1、首先，需要一个map对像存储每个元素上一次出现的位置，比如cur=map(A.charAt(i)) 表示的就是第i号元素上一次出现的位置
     * 2、还需要一个变量pre存放i-1号元素上一次出现的位置
     * 3、用一个变量max记录当前最大的子串长度
     * 4、只需要判断i元素上次出现的位置cur和i-1号元素上次出现的位置pre，选择其中大的那个即表示i号元素最大连续子串开始的位置
     *    此时只需用temp=i-Max(cur,pre)即可的到当前最大的子串长度
     * 5、在第四步之后只需要更新相应的pre、cur、map的值就行
     *
     * @param A
     * @param n
     * @return
     */
    public static int longestSubstring(String A, int n) {
        //哈希表存储 字符a上次出现的位置i
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int pre = -1,cur = -1, temp = 0, max = 0;
        map.put(A.charAt(0), 0);

        for (int i = 1; i < n; i++) {
            if(map.get(A.charAt(i)) != null){
                cur = map.get(A.charAt(i));
            }else {
                cur = -1;
            }

            if (pre > cur) {
                temp = i - pre;
            }else {
                temp = i - cur;
                pre = cur;
            }
            map.put(A.charAt(i), i);


            max = Math.max(max, temp);
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "aabcb";
        System.out.println(longestSubstring(str, 5));
    }

}
