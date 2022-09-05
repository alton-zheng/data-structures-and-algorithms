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

        // s 长度
        int len = s.length();

        // len == 1 时，说明最长回文串就是 s
        if (len == 1) {
            return s;
        }

        // 将 s char[] 化
        char[] source = s.toCharArray();

        // dp help 数组， 二维大小均为 len + 1， 记录是否被访问过
        boolean[][] help = new boolean[len + 1][len + 1];

        // 初始化 left , right 为 0
        int left = 0, right = 0;

        // 结果串长度
        int resLen = 0;

        // 开始遍历，r 移到最左边，向右边移动
        // l 初始化为 r, 向左边移动
        for (int r = 1; r < len + 1; r++) {
            for (int l = r; l >= 1; l--) {

                // 当 l == r 时
                if (l == r) {

                    // l, r 位置相同， 记录 help[l][r] 为回文串
                    help[l][r] = true;

                    // 结果串长度小于 0 时，更新 left, right, resLen
                    if (resLen < 0) {
                        left = l;
                        right = r;
                        resLen = 1;
                    }

                } else {

                    // l, r 位置值相同
                    // 下面两种场景：
                    // 1. [l,r] 在相邻的两个字符
                    // 2. l + 1, r - 1 范围都属于回文
                    // 那么 [l, r] 范围内都是回文串
                    if (source[l - 1] == source[r - 1]
                            && (r - l == 1 || help[l + 1][r - 1])) {
                        help[l][r] = true;
                    }

                }

                // 满足两个条件：
                // 1. [l, r] 范围内是回文串
                // 2. r - l + 1 大小大于之前 resLen 时，说明
                // [l, r] 范围更大，更新 left, right, resLen
                // 为了免除误会，这里的 l, r 比 s 的实际索引位置偏大 1
                // 所以，回文串实际位置为 [s[l - 1], s[r - 1]] 范围内
                if (help[l][r] && r - l + 1 > resLen) {
                    left = l;
                    right = r;
                    resLen = r - l + 1;
                }
            }


        }

        // 返回 s 的  [left - 1, right)
        return s.substring(left - 1, right);

    }
}
