package java00172.m04;

/**
 * @Author: alton
 * @Date: Created in 6/26/21 2:19 PM
 * @Description:
 *
 * Runtime: 3 ms, faster than 14.12% of Java online submissions for Factorial Trailing Zeroes.
 * Memory Usage: 36 MB, less than 42.13% of Java online submissions for Factorial Trailing Zeroes.
 *
 * Time Complexity : O(logN)
 * Space Complexity ; O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Factorial Trailing Zeroes.
 * Memory Usage: 36 MB, less than 42.13% of Java online submissions for Factorial Trailing Zeroes.
 */

class Solution {
    public int trailingZeroes(int n) {

        int res = 0;
        int power5 = 5;
        while (n >= power5) {
            res += n / power5;
            power5 *= 5;
        }

        return res;
    }
}
