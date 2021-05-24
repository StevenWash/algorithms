package lintcode

type NodeList struct {
	val int
	next *NodeList
}

// GetCrossedNodeNoLoop 判断两个无环单向链表是否相交，如果相交，返回第一个相交的节点，否则返回nil
func GetCrossedNodeNoLoop(list1 *NodeList, list2 *NodeList) *NodeList {

	if list1 == nil || list2 == nil {
		return nil
	}

	l1Head := list1
	l2Head := list2
	for (l1Head == nil || l2Head == nil) || (l1Head.val != l2Head.val) {
		if l1Head != nil {
			l1Head = l1Head.next
		} else {
			l1Head = list2
		}

		if l2Head != nil {
			l2Head = l2Head.next
		} else {
			l2Head = list1
		}
	}

	return l1Head
}

// GetLoopNode 判断一个链表是否有环，如果有环，找到入环的第一个节点
func GetLoopNode(list *NodeList) *NodeList{

	if list == nil || list.next == nil{
		return nil
	}

	l1 := list
	l2 := list.next

	for l1 != l2 {

		if l2.next == nil || l2.next.next == nil {
			return nil
		}

		l1 = l1.next
		l2 = l2.next.next
	}

	l2 = list
	l1 = l1.next
	for l1 != l2 {
		l1 = l1.next
		l2 = l2.next
	}

	return l1
}