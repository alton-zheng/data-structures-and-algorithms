package java00557.m03;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: alton
 * @Date: Created in 6/30/21 11:13 AM
 * @Description:
 *
 * 557. Reverse Words in a String III #162
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 *
 * Time Complexity :O(N)
 * Space Complexity : O(N)
 * Runtime: 21 ms, faster than 20.08% of Java online submissions for Reverse Words in a String III.
 * Memory Usage: 39.6 MB, less than 64.52% of Java online submissions for Reverse Words in a String III.
 */
class Solution {
    public String reverseWords(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder res =  new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                while(!stack.isEmpty()) {
                    res.append(stack.pop());
                }
                res.append(' ');
            } else {
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.toString();

    }
}
