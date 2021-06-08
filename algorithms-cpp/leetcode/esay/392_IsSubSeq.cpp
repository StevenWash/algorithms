//
// Created by stevenhua on 2021/6/7.
//
/*
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

致谢：

特别感谢 @pbrother 添加此问题并且创建所有测试用例。

 

示例 1：

输入：s = "abc", t = "ahbgdc"
输出：true
示例 2：

输入：s = "axc", t = "ahbgdc"
输出：false
 

提示：

0 <= s.length <= 100
0 <= t.length <= 10^4
两个字符串都只由小写字符组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

#include <string>

using namespace std;

class IsSubSequence {
public:
    // 判断s是否为t的子序列
    bool isSubsequence(string s, string t) {

        int s_len = s.length();
        int t_len = t.length();

        int i = 0, j = 0;

        while (i < s_len && j < t_len) {
            if (s[i] == t[j]) {
                // 如果当前字符相等，则两个指针都往下移动
                i++;
                j++;
            } else {
                // 如果不等，需要移动t的指针，继续比较下一个字符是否相等
                j++;
            }
        }

        // 如果最后遍历完s字符串，表示找到t中有关于s的子序列
        if (i >= s_len) {
            return true;
        }

        return false;
    }
};

void test_392_is_sub_seq() {

    IsSubSequence isSubSequence;

    string s = "abxc";
    string t = "ahbgdc";

    bool res = isSubSequence.isSubsequence(s, t);
    printf("res: %d\n", res);
}