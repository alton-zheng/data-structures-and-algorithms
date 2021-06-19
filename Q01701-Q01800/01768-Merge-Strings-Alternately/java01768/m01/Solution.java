package java01768.m01;

/**
 * @Author: alton
 * @Date: Created in 6/19/21 10:06 AM
 * @Description:
 *
 * 1768. Merge Strings Alternately #126
 *
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Strings Alternately.
 * Memory Usage: 37.2 MB, less than 74.86% of Java online submissions for Merge Strings Alternately.
 *
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {

        int word1Len = word1.length();
        int word2Len = word2.length();

        StringBuilder res = new StringBuilder();

        int word1Index = 0;
        int word2Index = 0;
        while (word1Index < word1Len && word2Index < word2Len) {
            res.append(word1.charAt(word1Index++)).append(word2.charAt(word2Index++));
        }

        while (word1Index < word1Len) {
            res.append(word1.charAt(word1Index++));
        }

        while (word2Index < word2Len) {
            res.append(word2.charAt(word2Index++));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("afg", "bcd"));
    }
}
