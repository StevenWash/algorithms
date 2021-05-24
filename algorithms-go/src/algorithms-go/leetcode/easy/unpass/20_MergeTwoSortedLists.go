package unpass

import (
	"algorithms-go/leetcode/common/types"
	"fmt"
)

//
//Merge two sorted linked lists and return it as a new list.
//The new list should be made by splicing together the nodes of the first two lists.
//
//Example:
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4

func mergeTwoLists(l1 *types.ListNode, l2 *types.ListNode) *types.ListNode {
	if l1 == nil {
		return l2
	}
	tmp := &types.ListNode{}
	if l2 != nil && l1.Val > l2.Val {
		tmp = l1
		l1 = l2
		l2 = tmp
	}

	result := l1

	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			tmp.Next = l1
			tmp = l1
			l1 = l1.Next

		} else {

			tmp.Next = l2
			tmp = l2
			l2 = l2.Next
		}
	}

	if l1 == nil && tmp != nil {
		tmp.Next = l2
	}

	return result
}

func main() {

	l1_nums:= [7]int{-10,-9,-6,-4,1,9,9}
	l1 := types.ListNode{Val: l1_nums[0]}
	tmp := &l1
	for i := 1 ; i < len(l1_nums); i++{
		tmp.Next = &types.ListNode{Val: l1_nums[i]}
		tmp = tmp.Next
	}

	l2_nums := [6]int{-5,-3,0,7,8,8}
	l2 := types.ListNode{Val: l2_nums[0]}
	tmp = &l2
	for i := 1 ; i < len(l2_nums); i++{
		tmp.Next = &types.ListNode{Val: l2_nums[i]}
		tmp = tmp.Next
	}


	l := mergeTwoLists(&l1, &l2)

	for ;l != nil; l = l.Next {
		fmt.Println(l.Val)
	}
}
