package java00342;

import java.math.BigInteger;

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
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
class Solution2 {
    public boolean isPowerOfFour(int n) {


        String s = Integer.toBinaryString(n);

        if ((s.length() - 1) % 2 == 0) {
            return n > 0 && (n & (n - 1)) == 0;
        }

        return false;
    }
}