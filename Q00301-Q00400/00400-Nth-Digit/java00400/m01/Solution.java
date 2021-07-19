package java00400.m01;

/**
 * @Author: alton
 * @Date: Created in 7/19/21 4:52 PM
 * @Description:
 *
 * Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 3
 * Example 2:
 *
 * Input: n = 11
 * Output: 0
 * Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 *
 * Time Complexity : O(len)
 * Space Complexity : O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Nth Digit.
 * Memory Usage: 35.7 MB, less than 60.86% of Java online submissions for Nth Digit.
 */
class Solution {
    public int findNthDigit(int n) {
        long base = 9, dig = 1;
        int num = 0;
        while(n > base * dig){
            n -= base * dig;
            num += base;
            base *= 10;
            dig++;
        }

        num += (n - 1) / dig + 1;
        int idx = (int)((n - 1) % dig + 1);

        while(dig-- > idx) {
            num /= 10;
        }
        return num % 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(200));
    }
}
