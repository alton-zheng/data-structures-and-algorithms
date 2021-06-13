package java00482.m02;

import java.util.ArrayList;
import java.util.List;

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
 * Time Complexity: O()
 * Space Complexity O()
 * Runtime: 82 ms, faster than 16.30% of Java online submissions for License Key Formatting.
 * Memory Usage: 44.5 MB, less than 5.07% of Java online submissions for License Key Formatting.
 *
 */
class Solution {
    public String licenseKeyFormatting(String s, int k) {

        StringBuilder temp = new StringBuilder();
        StringBuilder help = new StringBuilder();

        for (int i = s.length() - 1;  i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur != '-') {
                help.insert(0, cur < 91 ? cur : (char)(cur - 32));
            }

            if (help.length() == k) {
                temp.insert(0, help.toString()).insert(0, '-');
                help.setLength(0);
            }
        }

        temp.insert(0, help);

        if (temp.length() == 0) {
            return "";
        }

        String res = temp.toString();

        return res.charAt(0) == '-' ? res.substring(1) : res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
