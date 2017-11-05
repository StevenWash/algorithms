package com.huaxin.easy;

import javax.sound.midi.Soundbank;
import java.math.BigInteger;

/**
 * description : Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1 :
 * Input: 123
 * Output: 321
 * <p>
 * Example 2 :
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {

    public static int reverse(Integer x) {

        boolean flag;//为正
        int len;
        int temp_integer;

        //先判断当前数字是正还是负
        if (x>0) {
            flag = true;
            len = (x + "").length();
        } else {
            flag = false;
            len = (x + "").length() - 1;
        }

        temp_integer = flag?x:(-x);
        StringBuilder str_x = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str_x.append(temp_integer % 10);
            temp_integer = temp_integer / 10;
        }
        try {
            temp_integer = Integer.parseInt(str_x.toString());
            temp_integer = flag ? temp_integer : (0 - temp_integer);
            return temp_integer;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));

    }

}
