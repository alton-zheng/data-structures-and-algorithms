package java0101;

/**
 * @Author: alton
 * @Date: Created in 2021/9/4 7:03 下午
 * @Description:
 *
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * Time Complexity: O()
 * Space Complexity: O()
 * 执行用时：0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 29.09% 的用户
 */
class Solution {
    public int fib(int n) {
        long first = 0, second = 1;
        int mod = 1000000007;
        if (n < 2) {
            return n;
        }

        long res = 0;

        for (int i = 2; i <= n; i++) {
            res = (second + first) % mod;
            first = second;
            second = res;
        }

        return (int)res;
    }
}
