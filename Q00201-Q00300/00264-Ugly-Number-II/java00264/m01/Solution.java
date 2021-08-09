package java00264.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/9 3:27 下午
 * @Description:
 * 264. Ugly Number II #289
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1690
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public int nthUglyNumber(int n) {

        int[] primes = new int[]{1,2,3,5};

        int[] dp = new int[n + 1];
        dp[1] = 1;

        int[] pointers = new int[4];
        Arrays.fill(pointers, 1);

        int[] temp = new int[4];

        for (int i = 2; i <= n; i++) {

            int minValue = Integer.MAX_VALUE;

            for (int j = 1; j <= 3; j++) {
                temp[j] = dp[pointers[j]] * primes[j];
                minValue = Math.min(minValue, temp[j]);
            }
            dp[i] = minValue;

            for (int j = 1; j <= 3; j++) {
                if (minValue == temp[j]) {
                    pointers[j]++;
                }
            }
        }

        return dp[n];
    }
}
