package com.huaxin.paixu;

/**
 * 进行插入排序
 */
public class InsertOrder {

    /**
     * 简单实现了插入排序，思路也是很简单
     * 注意一点：做了简单的一点优化，那就是在if (src[j]<src[j-1])不成立的时候直接break了
     * 因为在j前面的元素已经是排好序的了，如果src[j]>=src[j-1],那么一定src[j]大于等于所有小于j的元素
     * 所以，就不需要再比较了，直接结束
     * @param src
     * @return
     */
    public static int[] insertOrder(int []src) {
        int temp;
        for (int i = 1; i<src.length; i++) {
            for (int j = i; j >=1; j--) {
                if (src[j]<src[j-1]) {
                    temp = src[j];
                    src[j] = src[j-1];
                    src[j-1] = temp;
                }else {
                    break;
                }
            }
        }

        return src;
    }

    public static void main(String[] args) {
        int [] src = {2,1,5,6,1,7,4,3,3,9,2,7};
        src = insertOrder(src);

        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
    }

}
