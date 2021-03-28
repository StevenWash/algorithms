package main

import (
	"fmt"
	"math"
	"strconv"
)

// Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1:
//
// Input: 123
// Output: 321
//
// Example 2:
//
// Input: -123
// Output: -321
//
// Example 3:
//
// Input: 120
// Output: 21
//
// Note:
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
func reverse(x int)int {
	tag := false
	if x < 0 {
		tag = true
		x = 0 - x
	}
	strX := strconv.Itoa(x)
	tmp  := "0"
	for i := len(strX)-1; i >= 0; i-- {
		tmp = tmp + strconv.Itoa(x % 10)
		x = x / 10
	}
	r,_ := strconv.Atoi(tmp)
	if tag {
		r = 0 - r
	}
	if r > int(math.Pow(2, 31)-1) || r < int(-math.Pow(2, 31)){
		return 0
	}
	return r
}

func main() {
	num := 1534236469
	re := reverse(num)
	fmt.Println("result:", re)
}
