package java00664;

/**
 * @Author: alton
 * @Date: Created in 5/24/21 2:30 PM
 * @Description:
 * 664. Strange Printer #39
 *
 * There is a strange printer with the following two special properties:
 *
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
 * Given a string s, return the minimum number of turns the printer needed to print it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaabbb"
 * Output: 2
 * Explanation: Print "aaa" first and then print "bbb".
 * Example 2:
 *
 * Input: s = "aba"
 * Output: 2
 * Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists of lowercase English letters.
 *
 * Time Complexity: O(N^3)
 * Space Complexity: O(N^2)
 */
class Solution {
    public int strangePrinter(String s) {

        int sLen = s.length();
        int[][] dp = new int[sLen][sLen];

        for (int i = sLen - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < sLen; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }

        return dp[0][sLen - 1];
    }
}
