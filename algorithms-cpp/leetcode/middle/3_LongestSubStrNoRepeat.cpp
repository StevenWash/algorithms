//
// Created by stevenhua on 2021/3/30.
//

#include <string>
#include <unordered_set>
#include <iostream>

using namespace std;

// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//示例1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
//    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
//示例 4:
//
//输入: s = ""
//输出: 0
//
//
//提示：
//
//0 <= s.length <= 5 * 104
//s由英文字母、数字、符号和空格组成
//
class LongestSubstrNoRepeat {

public:
    int lengthOfLongestSubstring(string s) {

        if (s.length() <= 1) {
            return s.length();
        }

        int width = 2;

        for (int i = 0; i + width <= s.length(); ) {
            bool flag = judgeNoRepeat(s.substr(i, width));
            if (flag) {
                width++;
            } else {
                i += width;
            }
        }

        return width-1;
    }

    bool judgeNoRepeat(string s) {
        unordered_set<char> flags;

        for (int i = 0; i < s.length(); i++) {
            flags.insert(s[i]);
        }

        return flags.size() == s.length();
    }
};

void test_3_length_of_longest_substring() {

    string s = "bbqwebe2e123tebb";
    LongestSubstrNoRepeat longestSubstrNoRepeat;
    int width = longestSubstrNoRepeat.lengthOfLongestSubstring(s);
    cout << width << endl;
}