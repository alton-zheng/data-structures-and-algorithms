package java00131.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/7 7:15 下午
 * @Description:
 * 132. Palindrome Partitioning II #281
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.

 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 */
class Solution {
    public int minCut(String s) {
        int len = s.length();
        char[] source = s.toCharArray();

        // help[l][r] 代表 [l,r] 这一段是否为回文串
        boolean[][] help = new boolean[len + 1][len + 1];
        for (int r = 1; r <= len; r++) {
            for (int l = r; l >= 1; l--) {
                // 如果只有一个字符，则[l,r]属于回文
                if (l == r) {
                    help[l][r] = true;
                } else {
                    // 在 l 和 r 字符相同的前提下
                    if (source[l - 1] == source[r - 1]) {
                        // 如果 l 和 r 长度只有 2；或者 [l+1,r-1] 这一段满足回文，则[l,r]属于回文
                        if (r - l == 1 || help[l + 1][r - 1]) {
                            help[l][r] = true;
                        }
                    }
                }
            }
        }

        // res[r] 代表将 [1,r] 这一段分割成若干回文子串所需要的最小分割次数
        int[] res = new int[len + 1];
        for (int r = 1; r <= len; r++) {
            // 如果 [1,r] 满足回文，不需要分割
            if (help[1][r]) {
                res[r] = 0;
            } else {
                // 先设定一个最大分割次数（r 个字符最多消耗 r - 1 次分割）
                res[r] = r - 1;
                // 在所有符合 [l,r] 回文的方案中取最小值
                for (int l = 1; l <= r; l++) {
                    if (help[l][r]) res[r] = Math.min(res[r], res[l - 1] + 1);
                }
            }
        }

        return res[len];
    }
}
