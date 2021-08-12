package java00516.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/12 9:59 上午
 * @Description:
 * 516. Longest Palindromic Subsequence #298
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 *
 * Time Complexity: O(len ^ 2)
 * Space Complexity: O(len ^2)
 *
 * Runtime: 31 ms, faster than 84.50% of Java online submissions for Longest Palindromic Subsequence.
 * Memory Usage: 49.2 MB, less than 58.07% of Java online submissions for Longest Palindromic Subsequence.
 */
class Solution {
    public int longestPalindromeSubseq(String s) {

        int len = s.length();

        int[][] help = new int[len][len];


        for (int i = len - 1; i >= 0; i--) {

            help[i][i] = 1;
            int x = s.charAt(i);

            for (int j = i + 1; j < len; j++) {
                int y = s.charAt(j);

                help[i][j] = x == y ? help[i + 1][j - 1] + 2 : Math.max(help[i + 1][j],help[i][j - 1]);
            }
        }

        return help[0][len - 1];
    }
}