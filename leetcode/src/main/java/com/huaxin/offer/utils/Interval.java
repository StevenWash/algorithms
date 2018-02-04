/*
 * Copyright (c) 2017.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.utils;

/**
 * Description:
 * 用来存储一个间隔数组
 *
 * @author huaxin
 * @create 2017/12/08 15:25
 */
public class Interval {
    int start;
    int end;

    Interval() {
        start = 0; end = 0;
    }

    Interval(int s, int e) {
        start = s; end = e;
    }
}
