package java01844.m01;

/**
 * @Author: alton
 * @Date: Created in 6/18/21 9:45 PM
 * @Description:
 *
 * 1844. Replace All Digits with Characters #123
 *
 * You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.
 *
 * There is a function shift(c, x), where c is a character and x is a digit, that returns the xth character after c.
 *
 * For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
 * For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).
 *
 * Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "a1c1e1"
 * Output: "abcdef"
 * Explanation: The digits are replaced as follows:
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('c',1) = 'd'
 * - s[5] -> shift('e',1) = 'f'
 * Example 2:
 *
 * Input: s = "a1b2c3d4e"
 * Output: "abbdcfdhe"
 * Explanation: The digits are replaced as follows:
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('b',2) = 'd'
 * - s[5] -> shift('c',3) = 'f'
 * - s[7] -> shift('d',4) = 'h'
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists only of lowercase English letters and digits.
 * shift(s[i-1], s[i]) <= 'z' for all odd indices i.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Replace All Digits with Characters.
 * Memory Usage: 37.1 MB, less than 74.02% of Java online submissions for Replace All Digits with Characters.
 *
 */
class Solution {
    public String replaceDigits(String s) {

        int len = s.length();
        char[] sChar = s.toCharArray();
        for (int i = 1; i < len; i += 2) {
            sChar[i] = (char)(sChar[i] - '0' + sChar[i - 1]);
        }

        return String.valueOf(sChar);
    }
}