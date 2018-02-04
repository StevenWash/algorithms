package com.huaxin.string;

/**
 * 给定两个字符串，判断两个字符串是否互相为旋转词
 *
 * 如：1234的旋转词有：2341、3412、4123
 */
public class RotateWord {

    /**
     * 给定输入两个字符串，判断这两个字符串是否是互相为旋转词
     * @param str1
     * @param str2
     * @return
     */
    public static boolean judgeInverse(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        return FindSubString.KMP(str1 + str1, str2) > -1;
    }

    public static void main(String[] args) {
        String str1 = "PVNMCXZNZBETCM";
        String str2 = "CNTZXMNZEBMVCd";
        System.out.println(judgeInverse(str1, str2));
    }
}
