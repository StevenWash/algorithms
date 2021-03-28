/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.offer.offerproblems;

/**
 * 用串的简单匹配算法替换字符串中的某一段字符
 * @author 鑫
 *
 */
public class ReplaceAllBlankSpace {
    final static String repStr=" ";

    public static String replaceBlank(String srcStr){
        char[] repS=repStr.toCharArray();
        char[] srcS=srcStr.toCharArray();
        int i=0,j=0,k=0;
        int f=0;
        int cnt=0;

        while(i<repS.length&&j<srcS.length){
            while(i<repS.length&&j<srcS.length&&repS[i]!=srcS[j]){
                j++;
            }
            k=j+1;
            j++;i++;
            while(i<repS.length&&j<srcS.length&&repS[i]==srcS[j]){
                i++;j++;
            }
            if(i>=repS.length){
                f=k-1;
                while(f<srcS.length&&f+repS.length<srcS.length){
                    srcS[f]=srcS[f+repS.length];
                    f++;
                }
                cnt++;
                i=0;
                j=k;
            }else{
                i=0;
                j=k;
            }

        }

        StringBuffer s=new StringBuffer();
        for(int m=0;m< srcStr.length()-cnt*repStr.length();m++){
            s.append(srcS[m]);
        }
        return s.toString();
    }

    public static String replaceSpace(StringBuffer str) {
        int i = str.indexOf(" ");
        while(i>=0) {
            str.replace(i,i+1,"%20");
            i = str.indexOf(" ");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str="Hello"+repStr+"World!Welcom"+repStr+"to"+repStr+"WuHan!";
        String result = ReplaceAllBlankSpace.replaceBlank(str);
        System.out.println(result);

        String result2 = ReplaceAllBlankSpace.replaceSpace(new StringBuffer(str));
        System.out.println(result2);


    }

}