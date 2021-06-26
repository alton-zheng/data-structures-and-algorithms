package java00172.m01;

import java.math.BigInteger;

/**
 * @Author: alton
 * @Date: Created in 6/26/21 11:42 AM
 * @Description:
 * 172. Factorial Trailing Zeroes #149
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 * <p>
 * Input: n = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 104
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
