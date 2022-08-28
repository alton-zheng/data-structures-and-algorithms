package java00172.m01;

import java.math.BigInteger;

/**
 * @Author: alton
 * @Date: Created in 6/26/21 11:42 AM
 * @Description:
 * 172. Factorial Trailing Zeroes #149
 * <p>
172. 阶乘后的零
给定一个整数 n ，返回 n! 结果中尾随零的数量。

提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1

示例 1：

输入：n = 3
输出：0
解释：3! = 6 ，不含尾随 0

示例 2：
输入：n = 5
输出：1
解释：5! = 120 ，有一个尾随 0

示例 3：
输入：n = 0
输出：0

提示：
0 <= n <= 10^4
 * <p>
 * Time Complexity : O()
 * Space Complexity : O()
 *
 * Time Limit Exceeded
 */
class Solution {
    public int trailingZeroes(int n) {

        // Calculate n!
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Count how many 0's are on the end.
        int zeroCount = 0;

        while (factorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            factorial = factorial.divide(BigInteger.TEN);
            zeroCount++;
        }

        return zeroCount;

    }
}
