package java00483.m01;

/**
 * @Author: alton
 * @Date: Created in 6/18/21 8:22 PM
 * @Description:
 * 483. Smallest Good Base
 *
 * Given an integer n represented as a string, return the smallest good base of n.
 *
 * We call k >= 2 a good base of n, if all digits of n base k are 1's.
 *
 *
 *
 * Example 1:
 *
 * Input: n = "13"
 * Output: "3"
 * Explanation: 13 base 3 is 111.
 * Example 2:
 *
 * Input: n = "4681"
 * Output: "8"
 * Explanation: 4681 base 8 is 11111.
 * Example 3:
 *
 * Input: n = "1000000000000000000"
 * Output: "999999999999999999"
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.
 *
 *
 * Constraints:
 *
 * n is an integer in the range [3, 1018].
 * n does not contain any leading zeros.
 *
 * Runtime: 2 ms, faster than 72.73% of Java online submissions for Smallest Good Base.
 * Memory Usage: 37.4 MB, less than 55.84% of Java online submissions for Smallest Good Base.
 *
 * Time Complexity : O(log^2 * n)
 * Space Complexity : O(1)
 *
 */
class Solution {
    public String smallestGoodBase(String n) {

        // define 1..1 (m + 1 len)
        // (11...11)k = k^0 + k^1 + ... + k^{m - 1} + k^{m} = n
        // m < log_2 * 10^{18} < 60
        // k^m < n < (k+1)^m
        // k < n^{1/m} < k+1

        // string n -> long nVal
        long nL = Long.valueOf(n);

        int mMax = (int)Math.floor(Math.log(nL) / Math.log(2));

        for (int m = mMax; m > 1; m--) {

            int k = (int) Math.pow(nL, 1.0 / m);

            long mul = 1, sum = 1;

            for (int i = 1; i < m + 1; i++) {
                mul *= k;
                sum += mul;
            }

            if (sum == nL) {
                return String.valueOf(k);
            }

        }

        return String.valueOf(nL - 1);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestGoodBase("2251799813685247"));
    }
}
