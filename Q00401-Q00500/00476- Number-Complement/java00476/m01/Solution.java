package java00476.m01;

/**
 * @Author: alton
 * @Date: Created in 6/21/21 12:41 PM
 * @Description:
 *
 * 476. Number Complement #134
 *
 * Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 *
 * Input: num = 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 *
 * Constraints:
 *
 * The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
 * num >= 1
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * Time Complexity : O(L)
 * Space Complexity : O(L)
 *
 * Runtime: 1 ms, faster than 29.81% of Java online submissions for Number Complement.
 * Memory Usage: 35.8 MB, less than 61.23% of Java online submissions for Number Complement
 *
 */
class Solution {
    public int findComplement(int num) {
        String source = Integer.toBinaryString(num);
        char[] res = source.toCharArray();

        for (int i = 0; i < res.length; i++) {
            if (res[i] == '0') {
                res[i] = '1';
            } else {
                res[i] = '0';
            }
        }

        return Integer.parseInt(String.valueOf(res), 2);
    }
}
