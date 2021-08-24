package java00005.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/24 4:47 下午
 * @Description: 5. Longest Palindromic Substring #337
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 * <p>
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 * <p>
 * Input: s = "ac"
 * Output: "a"
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * <p>
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 */
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();

        if (len == 1) {
            return s;
        }

        char[] source = s.toCharArray();

        boolean[][] help = new boolean[len + 1][len + 1];

        int left = 0, right = 0;
        int resLen = 0;

        for (int r = 1; r < len + 1; r++) {
            for (int l = r; l >= 1; l--) {
                if (l == r) {
                    help[l][r] = true;
                    if (resLen < 0) {
                        left = l;
                        right = r;
                        resLen = 1;
                    }

                } else {
                    if (source[l - 1] == source[r - 1]) {
                        if (r - l == 1 || help[l + 1][r - 1]) {
                            help[l][r] = true;


                        }
                    }

                }
                if (help[l][r] && r - l + 1 > resLen) {
                    left = l;
                    right = r;
                    resLen = r - l + 1;
                }
            }


        }

        return s.substring(left - 1, right);

    }
}
