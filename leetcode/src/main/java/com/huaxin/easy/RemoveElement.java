package com.huaxin.easy;

/**
 * Description:
 *   Given an array and a value, remove all instances of
 *   that value in-place and return the new length.
 *   Do not allocate extra space for another array,
 *   you must do this by modifying the input array in-place with O(1) extra memory.
 *   The order of elements can be changed.
 *   It doesn't matter what you leave beyond the new length.
 *
 * Example:
 *   Given nums = [3,2,2,3], val = 3,
 *   Your function should return length = 2,
 *   with the first two elements of nums being 2.
 */
public class RemoveElement {

    /**
     * 最优解
     *
     * 思路：遍历整个数组，当遇到值等于val的时候，就将count自增一下，表示数组中值是val的个数
     *      所以，遍历完之后，l - count 即表示剩余数组元素的个数。
     *      顺序遍历之后，如果数组元素不等于val了，这将该元素放到j指示的位置
     *      其中j指示的位置就是去除val之后的新数组的下标
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int l = nums.length;
        int count=0;
        int j=0;
        for(int i=0;i<l;i++){
            if(val==nums[i]){
                count++;
            }else{
                nums[j]=nums[i];
                j++;
            }
        }
        return l-count;
    }

    /**
     * 次优解
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int index = nums.length;

        for (int i = 0 ;i<index;i++) {
            if (nums[i] == val) {
                while(index>i&&nums[index-1]==val){
                    index--;
                }
                if (index<=i){
                    return index;
                }
                nums[i] = nums[index-1];
                index--;
            }
        }
        return index;
    }

    /**
     * 简单解
     *
     * 思路：用index记录最后一个元素，然后用i来进行遍历操作，当i对应的元素是val，
     *      且此时的i的坐标还没有超过index，则将index对应的值传给i位即可，
     *      然后index的游标往下减即可，最后index即表示最后剩余的元素的个数
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int index = nums.length;

        for (int i = 0 ;i<index;i++) {
            while ((nums[i] == val)&&(index>i)) {
                nums[i] = nums[index-1];
                index--;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int []nums = {5,2,2,5};
        int val = 5;
        System.out.println(removeElement2(nums, val));
    }
}
