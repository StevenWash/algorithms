package com.huaxin.string;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 对字符串的几种操作：
 *   1、将一个句子中的单词进行倒序输出："dog loves pig"  =>  "pig loves dog"
 *   2、将一个给定的字符串str的第0到i个字符移到右边，将第i+1到str.len个字符移到左边
 *   3、将一个字符数组中的所有的元素按照某种方式进行拼接，使得拼接之后的字符串的字典顺序最小
 */
public class ReverseStringExam {

    /**
     * 将一句话进行倒序输出：dog loves pig  => pig loves pig
     *
     * 方法：1、先将整句话进行逆序输出
     *      2、然后将每个单词进行逆序输出
     *
     * @param str
     * @return
     */
    public static String reverseSentence(String str) {
        str = ReverseWord.reverseString(str);
        String []strs = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i< strs.length; i++) {
            stringBuffer.append(ReverseWord.reverseString(strs[i])+" ");
        }

        return stringBuffer.toString().substring(0, stringBuffer.toString().length()-1);
    }

    /**
     * 将一个给定的字符串str的第0到i个字符移到右边，将第i+1到str.len个字符移到左边
     *
     * 方法：1、先将i前面的字符串进行逆序的到str1
     *      2、然后将i之后的字符串进行逆序得到str2
     *      3、然后将str1+str2进心逆序输出
     * @param str
     * @param i
     * @return
     */
    public static String reversePartOfString(String  str, int i) {
        if (i<0 || i>str.length())
            return str;
        String str1 = str.substring(0, i);
        str1 = ReverseWord.reverseString(str1);
        String str2 = str.substring(i, str.length());
        str2 = ReverseWord.reverseString(str2);
        str = ReverseWord.reverseString(str1+str2);

        return str;
    }

    /**
     * 将传入的字符串数组中的每个元素以某种方式进行拼接，使得拼接之后的字符串的字典顺序最小
     * @param strs
     * @return
     */
    public static String concatOnOrder(String [] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuffer stringBuffer = new StringBuffer();
        Arrays.sort(strs, new MyComparator());

        for (int i = 0; i< strs.length; i++) {
            System.out.println(strs[i]);
            stringBuffer.append(strs[i]);
        }
        return stringBuffer.toString();

    }

    public static void main(String[] args) {
        String str = "dog loves pig";
        System.out.println(reverseSentence(str));

        String str1 = "AbcDefGh";
        System.out.println(reversePartOfString(str1, 4));

        String[] strs = {"abc", "de", "ba", "b"};
        System.out.println(concatOnOrder(strs));
    }
}

class MyComparator implements Comparator<String>{

    public int compare(String str1, String str2) {
        return (str1+str2).compareTo(str2+str1);
    }
}
