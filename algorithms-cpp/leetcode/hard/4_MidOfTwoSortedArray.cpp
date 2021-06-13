//
// Created by 华鑫 on 2021/4/11.
//

#include <vector>

using namespace std;

/*
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。


示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：

输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：

输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：

输入：nums1 = [2], nums2 = []
输出：2.00000
 

提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 

进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

 *
 */
class MidOfTwoSortedArray {
public:

    //  双指针
    // 时间复杂度是： O((m+n)/2)
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {

        int l1 = nums1.size();
        int l2 = nums2.size();
        int len = l1 + l2;

        int val1, val2;
        int i = 0, j = 0;

        // 循环的边界问题，如果len是奇数，中位数是第len/2 + 1位
        // 如果len是偶数，中位数是len/2 和len/2 + 1的平均数
        // 因此，可以看出，遍历的终点即为len/2 + 1,同时需要记录当前遍历元素的上一个元素
        // 用来计算在偶数场景下的中位数
        for (; (i + j) < len / 2 + 1;) {

            val1 = val2;

            if (i >= l1) {
                val2 = nums2[j++];
            }else if (j >= l2) {
                val2 = nums1[i++];
            } else {
                if(nums1[i] < nums2[j]) {
                    val2 = nums1[i++];
                } else {
                    val2 = nums2[j++];
                }
            }
        }

        if (len % 2 == 0) {
            return double(val1 + val2) / 2;
        } else {
            return val2;
        }
    }

};

void test_findMedianSortedArrays() {
    MidOfTwoSortedArray midOfTwoSortedArray;

    vector<int> nums1;
    nums1.push_back(1);
    nums1.push_back(3);
    nums1.push_back(4);
    nums1.push_back(7);
    nums1.push_back(11);

    vector<int> nums2;
    nums2.push_back(2);
    nums2.push_back(5);
//    nums2.push_back(6);
//    nums2.push_back(9);
//    nums2.push_back(10);

    auto res = midOfTwoSortedArray.findMedianSortedArrays(nums1, nums2);
    printf("res: %d\n", res);
}
