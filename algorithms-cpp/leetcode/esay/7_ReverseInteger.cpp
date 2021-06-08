//
// Created by 华鑫 on 2020/3/5.
//

#include <iostream>
#include <string>
#include <cmath>

using namespace std;
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321
 
示例 2:
输入: -123
输出: -321

示例 3:
输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 */
class ReverseInteger {
public:
    int reverse(int x) {
        if (x == 0 || (-10 < x && x < 10)) {
            return x;
        }

        // 排除边界值：-2^31，此时转为正数会溢出，且反转之后也会溢出
        if(x == -pow(2,31)) {
            return 0;
        }

        int tmp_x; // 存储不带符号的x的数值
        bool flag; // 标记是否为正数

        if (x > 0) {
            tmp_x = x;
            flag = true;
        } else{
            tmp_x = -x;
            flag = false;
        }

        string s = "";
        int x_len = to_string(tmp_x).length();

        for (int i = 0; i < x_len; ++i) {
            int t = tmp_x % 10;
            s += to_string(t);
            tmp_x /= 10;
        }

        try {
            int d = stoi(s);
            if(flag) {
                return d;

            } else {
                return -d;
            }
        } catch(exception e) {
            return 0;
        }
    }
};

void test_7_reverse_integer() {
    ReverseInteger ri;
    int result = ri.reverse(-2147483648);
//    int result = stoi("153423646999999");
    cout << "result: " << result << endl;
}
