package java00172.m03;

/**
 * @Author: alton
 * @Date: Created in 6/26/21 2:19 PM
 * @Description:
 *
 * Runtime: 3 ms, faster than 14.12% of Java online submissions for Factorial Trailing Zeroes.
 * Memory Usage: 36 MB, less than 42.13% of Java online submissions for Factorial Trailing Zeroes.
 *
 * Time Complexity : O(N)
 * Space Complexity ; O(1)
 */

class Solution {
    public int trailingZeroes(int n) {

        int res = 0;

        for (int i = 5; i < n + 1; i += 5) {
            int power5 = 5;
            while (i % power5 == 0) {
                res++;
                power5 *= 5;
            }
        }

        return res;
    }
}
