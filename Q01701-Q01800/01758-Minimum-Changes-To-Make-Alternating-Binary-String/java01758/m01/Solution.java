package java01758.m01;

/**
 * @Author: alton
 * @Date: Created in 7/1/21 9:37 PM
 * @Description:
 * 1758. Minimum Changes To Make Alternating Binary String
 *
 * You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
 *
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
 *
 * Return the minimum number of operations needed to make s alternating.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", which is alternating.
 * Example 2:
 *
 * Input: s = "10"
 * Output: 0
 * Explanation: s is already alternating.
 * Example 3:
 *
 * Input: s = "1111"
 * Output: 2
 * Explanation: You need two operations to reach "0101" or "1010".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s[i] is either '0' or '1'.
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * 不要考虑太多， 答案只有2中情况，要么 1 开，要么 0 开
 */
class Solution {
    public int minOperations(String s) {
        int zero = 0, one = 0;
        char flag = '1';

        for (char c : s.toCharArray()) {
            if (c == flag) {
                zero++;
            } else {
                one++;
            }
            flag = flag == '0'?'1':'0';
        }

        return Math.min(zero, one);
    }
}
