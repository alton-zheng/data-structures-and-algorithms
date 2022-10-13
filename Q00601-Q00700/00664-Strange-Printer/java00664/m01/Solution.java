package java00664.m01;

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
    public static int strangePrinter(String str) {

        int len = str.length();
        int[][] help = new int[len][len];

        help[len - 1][len - 1] = 1;
        for (int i = 0; i < len - 1; i++) {
            help[i][i] = 1;
            help[i][i + 1] = str.charAt(i) == str.charAt(i + 1) ? 1 : 2;
        }

        for (int left = len - 3; left >= 0; left--) {
            for (int right = left + 2; right < len; right++) {
                help[left][right] = right - left + 1;
                for (int k = left + 1; k <= right; k++){
                    help[left][right] =
                            Math.min(help[left][right], help[left][k - 1] + help[k][right] - (str.charAt(left) == str.charAt(k) ? 1 : 0));
                }
            }
        }

        return help[0][len - 1];
    }
}
