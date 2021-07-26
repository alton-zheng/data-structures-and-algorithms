package java01143.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/26 9:26 下午
 * @Description:
 * 1143. Longest Common Subsequence #243
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 * Time Complexity: O(x*y)
 * Space Complexity: O(x*y)
 * Runtime: 5 ms, faster than 99.65% of Java online submissions for Longest Common Subsequence.
 * Memory Usage: 42.8 MB, less than 63.93% of Java online submissions for Longest Common Subsequence.
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // 定义2字符长度变量
        int t1Len = text1.length(), t2Len = text2.length();

        // 将2字符 char 化，加快遍历速度
        char[] charA1 = text1.toCharArray(), charA2 = text2.toCharArray();

        // 定义 2 维 dp
        int[][] dp = new int[t1Len + 1][t2Len + 1];

        // 当字符为空时，另一个字符不管有多少位，其最长公共子序列肯定为 0, 与数值数组默认值保持一致，这里不显性的赋值了

        // 两字符遍历
        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {

                // 当 i - 1, j - 1位的字符相等时，其 dp[i][j] 等于其前一 dp 值加一
                if (charA1[i - 1] == charA2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不相等时，此时有2 中场景，要么 选择 text1 选择，要么 选择text2
                    // 取其最大值
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }

        // 返回将字符遍历完后的最大公共子序列值
        return dp[t1Len][t2Len];
    }
}
