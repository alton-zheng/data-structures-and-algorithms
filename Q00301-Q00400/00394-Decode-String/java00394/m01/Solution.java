package java00394.m01;

import java.util.Deque;
import java.util.Stack;

/**
 * @Author: alton
 * @Date: Created in 7/4/21 11:09 AM
 * @Description:
 *
 * 394. Decode String #175
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
 * Memory Usage: 36.4 MB, less than 99.49% of Java online submissions for Decode String.
 */
class Solution {
    public String decodeString(String s) {

        int len = s.length();
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStk = new Stack<>();

        StringBuilder res = new StringBuilder();
        StringBuilder help = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if  (cur >= '0' && cur <= '9') {
                int num = cur - '0';
                while (i + 1 < len && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numStk.push(num);
                continue;
            }

            if (cur == '[') {
                stack.push(res.toString());
                res = new StringBuilder();
                continue;
            }


            if (cur == ']') {
                int num = numStk.pop();
                help = help.append(stack.pop());
                while (num-- > 0) {
                    help.append(res);
                }

                res = help;
                help = new StringBuilder();
                continue;
            }

            res.append(cur);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("abc3[c3[3[d]]]xyz"));
        // "abccdddddddddcdddddddddcdddddddddxyz"
    }
}
