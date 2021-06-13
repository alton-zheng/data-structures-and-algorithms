package java00482.m03;

/**
 * @Author: alton
 * @Date: Created in 6/13/21 9:02 AM
 * @Description:
 *
 * 482. License Key Formatting
 *
 * You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
 *
 * We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
 *
 * Return the reformatted license key.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "5F3Z-2e-9-w", k = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string s has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Example 2:
 *
 * Input: s = "2-5g-3-J", k = 2
 * Output: "2-5G-3J"
 * Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of English letters, digits, and dashes '-'.
 * 1 <= k <= 104
 *
 * Time Complexity: O(n)
 * Space Complexity O(n)
 * Runtime: 13 ms, faster than 55.02% of Java online submissions for License Key Formatting.
 * Memory Usage: 42.3 MB, less than 10.23% of Java online submissions for License Key Formatting.
 *
 */
class Solution {
    public String licenseKeyFormatting(String s, int k) {

        StringBuilder res = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {

            // 排除 "-" 字符
            if (s.charAt(i) != '-') {
                // e.g. k = 5, res 长度为 4 或 9 时， 满足前面加 "-"
                // 其余情况，追加 字符（小写 -> 大写）
                res.append(res.length() % (k + 1) == k ? "-" : "").append(s.charAt(i) > 91 ? (char) (s.charAt(i) - 32) : s.charAt(i));
            }
        }

        // 反转结果即可
        return res.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
