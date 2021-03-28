package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type ListNode struct {
	Val int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	result := l1
	pointor := 0

	for l1 != nil && l2 != nil {
		l1.Val += pointor
		tmp := l1.Val + l2.Val
		if tmp >= 10 {
			pointor = 1
			l1.Val =  tmp - 10
		} else {
			pointor = 0
			l1.Val =  tmp
		}


		if  l1.Next != nil && l2.Next == nil {
			l := l2
			l2 = l1
			l1 = l
		}

		if l1.Next == nil {
			if l2.Next == nil {
				if pointor == 1 {
					l1.Next = &ListNode{pointor, nil}
					return result
				}
			} else {
				//l2 = l2.Next
				l1.Next = l2.Next
				for pointor == 1 && l2.Next != nil{
					l2 = l2.Next
					tmp := l2.Val +  pointor
					if tmp >= 10 {
						l2.Val = tmp - 10
						pointor = 1
					} else {
						pointor = 0
						l2.Val = tmp
					}


				}

				if pointor == 1 {
					l2.Next = &ListNode{1, nil}
				}


				return result
			}
		}


		l1 = l1.Next
		l2 = l2.Next
	}

	return result

}

func main() {

	//l1 := &ListNode{2, &ListNode{4, &ListNode{3, nil}}}
	l1 := &ListNode{5, nil}
	//l2 := &ListNode{0, nil}
	//l2 := &ListNode{5, &ListNode{6, &ListNode{4, nil}}}
	l2 := &ListNode{5, nil}

	res := addTwoNumbers(l1, l2)

	for res != nil {
		println(res.Val)
		res = res.Next
	}
	
}
