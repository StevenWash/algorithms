package unpass

import "fmt"

// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

// Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
//
// Example 1:
//
// Input: "III"
// Output: 3
//
// Example 2:
//
// Input: "IV"
// Output: 4
//
// Example 3:
//
// Input: "IX"
// Output: 9
//
// Example 4:
//
// Input: "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.
//
// Example 5:
//
// Input: "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
func romanToInt(s string) int {
	return 0
}

func main() {
	val := "LVII"
	res := romanToInt(val)
	fmt.Printf("result:%d", res)
}
