//
// Created by 华鑫 on 2021/3/7.
//

#include <string>
#include <iostream>

using namespace std;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

 示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
 

提示：

1 <= s.length <= 10^4
s 仅由括号 '()[]{}' 组成

 *
 */
class ValidCharacter {
public:

    /*
     * 利用栈的特点
     */
    bool isValid(string s) {

        if (s.length() == 0) {return false;}
        char stack[s.length()/2 + 1];
        int index = -1;
        for (int i = 0; i < s.size(); i++) {
            char tmpChar = s[i];
            if (tmpChar == '(' || tmpChar == '[' || tmpChar == '{') {
                if (index + 1 >= (s.length() / 2 + 1)) {return false;}
                stack[++index] = tmpChar;
            } else if (tmpChar == ')' || tmpChar == ']' || tmpChar == '}') {
                if (index < 0) {return false;}
                char cc = stack[index];
                switch (tmpChar) {
                    case ')':
                        if (cc == '(') {index--;} else {return false;}
                        break;
                    case ']':
                        if (cc == '[') {index--;} else {return false;}
                        break;
                    case '}':
                        if (cc == '{') {index--;} else {return false;}
                        break;
                }
            }
        }

        if (index == -1) {return true;}
        return false;
    }
};

void test_20_valid_character() {
    ValidCharacter valid;
    std::cout << "result:" << valid.isValid("[[(({}[[]]{()}))]]") << std::endl;
}
