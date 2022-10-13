package java00664.m02;

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
        int len = s.length();

        int[][] help = new int[len][len];

        for (int left = len - 1; left >= 0; left--) {
            help[left][left] = 1;
            for (int right = left + 1; right < len; right++) {
                if (s.charAt(left) == s.charAt(right)) {
                    help[left][right] = help[left][right - 1];
                } else {
                    help[left][right] = right - left + 1;
                    for (int k = left; k < right; k++) {
                        help[left][right] = Math.min(help[left][right], help[left][k] + help[k + 1][right]);
                    }
                }
            }
        }

        return help[0][len - 1];
    }
}
