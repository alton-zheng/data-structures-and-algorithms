package java01967.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/15 下午4:04
 * @Description:
 *
 * 1967. Number of Strings That Appear as Substrings in Word #309
 * Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: patterns = ["a","abc","bc","d"], word = "abc"
 * Output: 3
 * Explanation:
 * - "a" appears as a substring in "abc".
 * - "abc" appears as a substring in "abc".
 * - "bc" appears as a substring in "abc".
 * - "d" does not appear as a substring in "abc".
 * 3 of the strings in patterns appear as a substring in word.
 * Example 2:
 *
 * Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
 * Output: 2
 * Explanation:
 * - "a" appears as a substring in "aaaaabbbbb".
 * - "b" appears as a substring in "aaaaabbbbb".
 * - "c" does not appear as a substring in "aaaaabbbbb".
 * 2 of the strings in patterns appear as a substring in word.
 * Example 3:
 *
 * Input: patterns = ["a","a","a"], word = "ab"
 * Output: 3
 * Explanation: Each of the patterns appears as a substring in word "ab".
 *
 *
 * Constraints:
 *
 * 1 <= patterns.length <= 100
 * 1 <= patterns[i].length <= 100
 * 1 <= word.length <= 100
 * patterns[i] and word consist of lowercase English letters.
 * Time Complexity: O(n×∑_im_i)
 * Space Complexity: O(1)
 */
class Solution {

    private int len;
    private String word;
    public int numOfStrings(String[] patterns, String word) {
        len = word.length();
        this.word = word;

        int res = 0;
        for (String pattern: patterns) {
            res += check(pattern);
        }

        return res;
    }

    private int check(String pattern) {
        int p = pattern.length();

        for (int i = 0; i + p <= len; i++) {

            int flag = 1;

            for (int j = 0; j < p; j++) {
                if (pattern.charAt(j) != word.charAt(i + j)) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                return flag;
            }
        }

        return 0;
    }
}
