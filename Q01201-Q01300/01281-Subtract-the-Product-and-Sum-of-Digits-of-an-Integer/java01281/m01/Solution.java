package java01281.m01;

/**
 * @Author: alton
 * @Date: Created in 7/15/21 5:13 PM
 * @Description:
 *
 * 1281. Subtract the Product and Sum of Digits of an Integer #209
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 *
 *
 * Example 1:
 *
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * Example 2:
 *
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 *
 * Time Complexity : O(len)
 * Space Complexity : O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
 * Memory Usage: 35.5 MB, less than 91.66% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
 *
 */
class Solution {
    public int subtractProductAndSum(int n) {

        int mul = 1;
        int sum = 0;

        while (n > 0) {
            int cur = n % 10;
            mul *= cur;
            sum += cur;
            n /= 10;
        }

        return mul - sum;
    }
}
