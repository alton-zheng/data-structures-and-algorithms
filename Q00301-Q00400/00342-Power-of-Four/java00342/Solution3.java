package java00342;

/**
 * @Author: alton
 * @Date: Created in 5/25/21 3:00 PM
 * @Description:
 * 342. Power of Four
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 *
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 16
 * Output: true
 * Example 2:
 *
 * Input: n = 5
 * Output: false
 * Example 3:
 *
 * Input: n = 1
 * Output: true
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 *
 * 暴力破解
 * Time Complexity: O(N) N 是 4 的 N 次方
 * Space Complexity: O(1)
 */
class Solution3 {
    public boolean isPowerOfFour(int n) {

        int four = 4;
        int res = 1;
        while (res <= n) {
            if (res == n) {
                return true;
            }

            res = res * 4;
        }

        return false;
    }
}