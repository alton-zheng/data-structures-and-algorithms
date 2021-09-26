package java00371.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/9/26 8:21 上午
 * @Description:
 *
 * 371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 *
 *
 * 提示：
 *
 * -1000 <= a, b <= 1000
 *
 *
 */
class Solution {
    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
