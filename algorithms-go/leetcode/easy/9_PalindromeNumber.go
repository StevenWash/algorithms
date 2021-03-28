package main

import (
	"fmt"
	"strconv"
)

//
// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
// Example 1:
//
// Input: 121
// Output: true
//
// Example 2:
//
// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//
// Example 3:
//
// Input: 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

// Follow up:
//
// Coud you solve it without converting the integer to a string?
func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	strX := strconv.Itoa(x)
	i := 0
	j := len(strX)-1
	for ; i <= j; {
		if string(strX[i]) != string(strX[j]) {
			return false
		}
		i++
		j--
	}
	return true
}

func main() {
	x := 12221
	re := isPalindrome(x)
	fmt.Println("result:", re)
}
