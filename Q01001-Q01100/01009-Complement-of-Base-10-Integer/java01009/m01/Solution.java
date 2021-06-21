package java01009.m01;

/**
 * @Author: alton
 * @Date: Created in 6/21/21 2:28 PM
 * @Description:
 * 1009. Complement of Base 10 Integer #135
 *
 * Every non-negative integer n has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for n = 0, there are no leading zeroes in any binary representation.
 *
 * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
 *
 * For a given number n in base-10, return the complement of it's binary representation as a base-10 integer.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 *
 * Input: n = 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 *
 * Input: n = 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 *
 *
 * Note:
 *
 * 0 <= n < 109
 * This question is the same as 476: https://leetcode.com/problems/number-complement/
 *
 * Time Complexity : O(1)
 * Space Complexity : O(1)
 *
 */
class Solution {
    public int bitwiseComplement(int n) {

        if (n == 0) return 1;

        int mask = ~0;
        while ((mask & n) > 0) {
            mask <<= 1;
        }
        return ~mask ^ n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bitwiseComplement(13));
    }
}
