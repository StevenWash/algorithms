package main

import "fmt"

//
// Title: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//   You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
// Example:
//   Given nums = [2, 7, 11, 15], target = 9,
//
//   Because nums[0] + nums[1] = 2 + 7 = 9,
//   return [0, 1].
//

/**
 * 方法：暴力破解法
 * 思路：嵌套遍历两次nums数组，分别取一个值，判断两个值的和是否等于给定的target
 * 时空：时间复杂度O(n^2)   空间复杂度O(1)
 */
func twoSum1(nums []int, target int) []int {
	for i := 0; i < len(nums); i++ {
		for j := 0; j != i && j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				if i < j {
					return []int{i, j}
				} else {
					return []int{j, i}
				}

			}
		}
	}
	return []int{}
}

/**
 * 方法：一次遍历记录
 * 思路：重点在于需要辅助变量map,其key是nums中的值，value是该值在nums中的index，作用是将nums数组的index和value转置
 *      在遍历nums的时候，如果map中存在target - nums[i]的值，则表示nums中存在两个元素之和为target，则返回map中的value和i
 *      如果不存在，则将当前的nums[i]作为key,i作为value存放到map中
 * 时空：时间复杂度O(n^2)   空间复杂度O(1)
 */
func twoSum(nums []int, target int) []int {
	numMap := make(map[int]int)
	for i, num := range nums {
		tmp := target - num
		if v, ok := numMap[tmp]; ok {
			if v < i {
				return []int{v, i}
			} else {
				return []int{i, v}
			}
		}
		numMap[nums[i]] = i
	}
	return []int{}
}

func main() {
	nums := []int{2, 7, 11, 13, 4, 15}
	result := twoSum(nums, 17)
	fmt.Println("result:", result)
}
