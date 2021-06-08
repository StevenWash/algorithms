//
// Created by 华鑫 on 2021/3/9.
//

#include <vector>
#include <iostream>

using namespace std;

/**
 *
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0

*/
class SearchInsert {

public:
    int searchInsert(vector<int>& nums, int target) {

        int i = 0;

        for (i = 0; i < nums.size(); i++) {

            if (nums[i] >= target) {
                return i;
            }
        }

        return i;

    }

    int searchInsert2(vector<int>& nums, int target) {

        int i = nums.size() - 1;

        for (; i >= 0 ; i--) {

            if (nums[i] <= target) {
                return i + 1;
            }
        }

        return i + 1;

    }

};

void test_35_search_insert() {

    vector<int> nums;
    nums.push_back(1);
    nums.push_back(3);
    nums.push_back(5);
    nums.push_back(6);

    SearchInsert searchInsert;
    int len = searchInsert.searchInsert2(nums, 5);
    cout << len << endl;
}