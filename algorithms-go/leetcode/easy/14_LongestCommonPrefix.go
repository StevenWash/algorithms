package main

import "fmt"

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//Example 1:
//
//Input: ["flower","flow","flight"]
//Output: "fl"
//
//Example 2:
//
//Input: ["dog","racecar","car"]
//Output: ""
//
//Explanation: There is no common prefix among the input strings.
//
//Note:
//
//All given inputs are in lowercase letters a-z.
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}

	str := longestCommonPreTwoStrings(strs[0], strs[1])
	for i := 2; i < len(strs); i++  {
		str = longestCommonPreTwoStrings(str, strs[i])
	}

	return str
}

func longestCommonPreTwoStrings(str1 string, str2 string) string {
	i := 0
	for ; i < len(str1) && i < len(str2); i++ {
		if str1[i] != str2[i] {
			break
		}
	}
	return str1[:i]
}



func main() {
	strs := []string{"dog","racecar","car"}
	str := longestCommonPrefix(strs)
	fmt.Println("result:", str)
}
