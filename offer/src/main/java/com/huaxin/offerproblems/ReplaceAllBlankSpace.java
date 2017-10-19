package com.huaxin.offerproblems;

import java.util.Date;

/**
 * 用串的简单匹配算法替换字符串中的某一段字符
 * @author 鑫
 *
 */
public class ReplaceAllBlankSpace {
    final static String repStr="%ac&%huh%%ygygyg23LO";

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


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str="Hello"+repStr+"World!Welcom"+repStr+"to"+repStr+"WuHan!";
        int test=10000000;
        long start=new Date().getTime();
        System.out.println("开始前："+start);
        while(test>=0){
            ReplaceAllBlankSpace.replaceBlank(str);
            test--;
            str="Hello"+repStr+"World!Welcom"+repStr+"to"+repStr+"WuHan!";
        }
        long end=new Date().getTime();
        System.out.println("结束后："+end);
        System.out.println("持续了："+(end-start));
    }

}