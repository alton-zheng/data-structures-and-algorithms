package java00557.m04;

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
 * Space Complexity : O(1)
 * Runtime: 2 ms, faster than 99.85% of Java online submissions for Reverse Words in a String III.
 * Memory Usage: 39.3 MB, less than 91.19% of Java online submissions for Reverse Words in a String III.
 */
class Solution {
    public String reverseWords(String s) {
        char[] help = s.toCharArray();
        int len = help.length;

        int curIdx = 0;
        while (curIdx < len) {
            int left = curIdx;
            while (curIdx < len && help[curIdx] != ' ') {
                curIdx++;
            }

            int right = curIdx - 1;
            while (left < right) {
                swap(help, left, right);
                left++;
                right--;
            }

            while (curIdx < len && help[curIdx] == ' ') {
                curIdx++;
            }
        }

        return String.valueOf(help);
    }

    private void swap(char[] help, int left, int right) {
        char swap = help[left];
        help[left] = help[right];
        help[right] = swap;
    }
}
