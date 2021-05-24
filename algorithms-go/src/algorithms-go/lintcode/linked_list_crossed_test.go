package lintcode

import (
	"fmt"
	"testing"
)

func TestGetCrossedNodeNoLoop(t *testing.T) {

	l1 := &NodeList{
		val: 5,
		next: &NodeList{
			val: 7,
			next: &NodeList{
				val: 9,
				next: &NodeList{
					val: 11,
				},
			},
		},
	}

	l2 := &NodeList{
		val: 2,
		next: &NodeList{
			val: 4,
			next: &NodeList{
				val: 9,
				next: &NodeList{
					val: 11,
				},
			},
		},
	}

	res := GetCrossedNodeNoLoop(l1, l2)
	fmt.Printf("the cross node: %d\n", res.val)
}

func TestGetLoopNode(t *testing.T) {

	var nodeLoop *NodeList

	nodeLoop = &NodeList{
		val: 4,
		next: &NodeList{
			val: 5,
			next: &NodeList{
				val: 6,
				next: &NodeList{
					val: 7,
					next: &NodeList{
						val: 8,
						next: &NodeList{
							val: 9,
						},
					},
				},
			},
		},
	}

	nodeLoop.next.next.next.next.next.next = nodeLoop

	l1 := &NodeList{
		val: 1,
		next: &NodeList{
			val: 2,
			next: &NodeList{
				val: 3,
				next: nodeLoop,
			},
		},
	}


	res := GetLoopNode(l1)
	fmt.Printf("the cross node: %d\n", res.val)
}
