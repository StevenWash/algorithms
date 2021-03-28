package main

import "fmt"

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
//determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.
//
//Example 1:
//Input: "()"
//Output: true
//
//Example 2:
//Input: "()[]{}"
//Output: true
//
//Example 3:
//Input: "(]"
//Output: false

//Example 4:
//Input: "([)]"
//Output: false

//Example 5:
//Input: "{[]}"
//Output: true
func isValid(s string) bool {
	if len(s) <= 0 {
		return true
	}
	idx := 0
	l := len(s)
	fmt.Println("l:", l)
	stack := [10240]byte{}
	for i := 0; i< len(s); i++ {
		if s[i] == '(' || s[i] == '[' || s[i] == '{' {
			stack[idx] = s[i]
			idx++
		} else
		{
			if idx == 0 {
				return false
			}
			idx--
			t := stack[idx]
			switch s[i] {
			case '}':
				if t != '{' {
					return false
				}
				break
			case ']':
				if t != '[' {
					return false
				}
				break
			case ')':
				if t != '(' {
					return false
				}
				break
			default:
				return false
				break
			}

		}
	}
	if idx == 0 {
		return true
	}
	return false
}

func main() {
	str := "}"
	fmt.Println("len:", len(str))
	res := isValid(str)
	fmt.Println("result:", res)
}
