package java00263;

/**
 * @Author: alton
 * @Date: Created in 5/30/21 10:42 AM
 * @Description:
 * 263. Ugly Number #59
 *
 * 263. Ugly Number
 * Easy
 *
 * 794
 *
 * 803
 *
 * Add to List
 *
 * Share
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return true if n is an ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: n = 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 *
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 * Example 4:
 *
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 * Time Complexity ： O(log 5*n + log 3*n + log1*n)
 * Space Complexity: O(1)
 *
 * Violent SubrectangleQueries.cpp
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number.
 * Memory Usage: 36 MB, less than 40.25% of Java online submissions for Ugly Number.
 */
class Solution2 {
    public boolean isUgly(int n) {

        while (n % 5 == 0 && n > 0) {
            n /= 5;
        }

        while (n % 3 == 0 && n > 0) {
            n /= 3;
        }

        while (n % 2 == 0 && n > 0) {
            n /= 2;
        }

        return n == 1;

    }
}