package java00952.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/1 3:18 下午
 * @Description:
 * 01952-Three-Divisors #259
 *
 * Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
 *
 * An integer m is a divisor of n if there exists an integer k such that n = k * m.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: false
 * Explantion: 2 has only two divisors: 1 and 2.
 * Example 2:
 *
 * Input: n = 4
 * Output: true
 * Explantion: 4 has three divisors: 1, 2, and 4.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Three Divisors.
 * Memory Usage: 35.7 MB, less than 62.50% of Java online submissions for Three Divisors.
 */
class Solution {
    public boolean isThree(int n) {
        int cnt = 0;
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt += 2;
            }
        }

        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            cnt++;
        }
        return cnt == 3;
    }
}
