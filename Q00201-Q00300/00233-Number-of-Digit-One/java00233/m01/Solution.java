package java00233.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/13 8:15 上午
 * @Description:
 *
 * 233. Number of Digit One #301
 *
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * Example 1:
 * Input: n = 13
 * Output: 6
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 109
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Digit One.
 * Memory Usage: 37.8 MB, less than 5.94% of Java online submissions for Number of Digit One.
 */
class Solution {
    public int countDigitOne(int n) {

        int mulk = 1;

        int res = 0;

        for (int k = 0; n >= mulk; k++) {

            res += (n / (mulk * 10)) * mulk + Math.min(Math.max((n % (mulk * 10)) - mulk + 1, 0), mulk);
            mulk *= 10;
        }

        return res;
    }
}
