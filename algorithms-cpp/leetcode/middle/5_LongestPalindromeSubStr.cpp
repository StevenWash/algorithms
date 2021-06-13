//
// Created by 华鑫 on 2021/4/12.
//

/**
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
示例 4：

输入：s = "ac"
输出："a"
 

提示：

1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成

*
*/

#include <string>
#include <iostream>

using namespace std;

class LongestPalindromeSubStr {
public:
    string longestPalindrome(string s) {
        int size  = s.length();
        bool dp[size][size];

        string ans; // 存放当前最大的回文子串

        for (int len = 0; len < size; len++) {
            for (int i = 0; i + len < size; i++) {
                int j = len + i;
                if (len == 0) {
                    dp[i][j] = true;
                } else if (len == 1) {
                    dp[i][j] = (s[i] == s[j]);
                } else {
                    dp[i][j] = dp[i+1][j-1] && (s[i] == s[j]);
                }

                // 如果当前i,j也是回文串，并且当前回文串的长度(j-i+1)大于之前存放最大回文串的ans的长度
                // 则更新ans为i,j的回文串
                if (dp[i][j] && j-i+1 > ans.length()) {
                    // 注意： c++中substr的第二个参数是子串的长度，不是其他语言中子串的结束位置
                    ans = s.substr(i, j-i+1);
                }

            }

        }

        return ans;
    }
};

void test_longestPalindrome() {

    string s = "babad";
    LongestPalindromeSubStr longestPalindromeSubStr;
    string ans = longestPalindromeSubStr.longestPalindrome(s);
    cout << ans << endl;

    s = "cbbd";
    ans = longestPalindromeSubStr.longestPalindrome(s);
    cout << ans << endl;

    s = "ac";
    ans = longestPalindromeSubStr.longestPalindrome(s);
    cout << ans << endl;

    s = "a";
    ans = longestPalindromeSubStr.longestPalindrome(s);
    cout << ans << endl;
}