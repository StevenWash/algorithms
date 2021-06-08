
//
// Created by stevenhua on 2021/6/7.
//



/**
 *
 * 请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

#include "../common/ListNode.h"
#include <vector>

class LinkListPalindrome {
public:

    // 使用数组的方式来实现
    bool isPalindrome(ListNode* head) {

        if (head == nullptr) {
            return false;
        }

        int queue[1000000] = {0};
        int font = 0, tail = 0;

        while (head != nullptr) {
            queue[tail++] = head->val;
            head = head->next;
        }

        while (font < tail) {
            if (queue[font] == queue[tail-1]) {
                font++;
                tail--;
            } else {
                return false;
            }
        }

        return true;
    }

    // 使用c++的deque双向队列来实现
    bool isPalindrome2(ListNode* head) {
        if (head == nullptr) {
            return false;
        }
        std::vector<int> queue;

        while (head != nullptr) {
            queue.push_back(head->val);
            head = head->next;
        }

        for (int i = 0, j = queue.size(); i < j; ++i, --j) {
            if (queue[i] != queue[j]) {
                return false;
            }
        }

        return true;
    }
};

void test_234_is_link_list_palindrome() {

    ListNode* list = new ListNode(1);
    list->next = new ListNode(2);
    list->next->next = new ListNode(2);
    list->next->next->next = new ListNode(1);

    LinkListPalindrome linkListPalindrome;
    auto res = linkListPalindrome.isPalindrome(list);

    printf("res: %d\n", res);

}