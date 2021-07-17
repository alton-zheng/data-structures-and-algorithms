package java00392.m01;

/**
 * @Author: alton
 * @Date: Created in 7/17/21 10:02 PM
 * @Description:
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 *
 * Time Complexity : O(t)
 * Space Complexity : O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Subsequence.
 * Memory Usage: 37.1 MB, less than 47.66% of Java online submissions for Is Subsequence.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int i = 0, j = 0;

        while (i < sChar.length && j < tChar.length) {
            if (sChar[i] == tChar[j]) {
                i++;
            }
            j++;
        }
        return i == sChar.length;
    }
}
