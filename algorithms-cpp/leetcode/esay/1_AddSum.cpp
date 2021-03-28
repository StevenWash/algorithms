//
// Created by 华鑫 on 2019/12/5.
//

#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *   给定 nums = [2, 7, 11, 15], target = 9
 *   因为 nums[0] + nums[1] = 2 + 7 = 9
 *   所以返回 [0, 1]
 */

class AddSum {
public:
    /**
     * 方法：暴力破解法
     * 思路：嵌套遍历两次nums数组，分别取一个值，判断两个值的和是否等于给定的target
     * 时空：时间复杂度O(n^2)   空间复杂度O(1)
     */
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> re(2);
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j != i && j < nums.size() ; ++j) {
                if (nums.at(i) + nums.at(j) == target) {
                    if (i > j) {
                        i = i+j;j = i-j;i = i-j;
                    }
                    re.push_back(i);
                    re.push_back(j);
                    return re;
                }
            }
        }
        return re;
    }

    /**
     * 方法：一次遍历记录
     * 思路：重点在于需要辅助变量map,其key是nums中的值，value是该值在nums中的index，作用是将nums数组的index和value转置
     *      在遍历nums的时候，如果map中存在target - nums[i]的值，则表示nums中存在两个元素之和为target，则返回map中的value和i
     *      如果不存在，则将当前的nums[i]作为key,i作为value存放到map中
     * 时空：时间复杂度O(n)   空间复杂度O(n)
     */
    vector<int> twoSum2(vector<int>& nums, int target) {
        vector<int> re;
        int tmp;
        unordered_map<int, int> tmpMap;

        for (int i = 0; i < nums.size(); ++i) {
            tmp = target - nums[i];
            if (tmpMap.find(tmp) != tmpMap.end()) {
                int j = tmpMap[tmp];
                if (i < j) {
                    re.push_back(i);
                    re.push_back(j);
                } else {
                    re.push_back(j);
                    re.push_back(i);
                }
                return re;
            }
            tmpMap[nums[i]] = i;
        }
        return re;
    }
};

// 测试用例
void test_add_sum() {
    AddSum addSum;
    std::vector<int>obj;
    obj.push_back(2);
    obj.push_back(7);
    obj.push_back(11);
    obj.push_back(15);

    vector<int> result = addSum.twoSum2(obj, 17);
    for (int i = 0; i < result.size(); i++) {
        std::cout<<result.at(i)<<std::endl;
    }
}
