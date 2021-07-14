package java00316.m01;

/**
 * @Author: alton
 * @Date: Created in 7/14/21 11:28 AM
 * @Description:
 *
 * 316. Remove Duplicate Letters
 *
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^4
 * s consists of lowercase English letters.
 *
 * Time Complexity: O(N)
 * Space Complexity : O(26)
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Remove Duplicate Letters.
 * Memory Usage: 39.1 MB, less than 52.96% of Java online submissions for Remove Duplicate Letters.
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26], visit = new int[26];

        for (char c: s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (visit[c - 'a'] == 0) {

                while (res.length() != 0 && res.charAt(res.length() - 1) > c) {
                    if (cnt[res.charAt(res.length() - 1) - 'a'] > 0) {
                        visit[res.charAt(res.length() - 1) - 'a'] = 0;
                        res.deleteCharAt(res.length() - 1);
                    } else {
                        break;
                    }
                }

                visit[c - 'a'] = 1;
                res.append(c);
            }

            cnt[c - 'a']--;
        }

        return res.toString();

    }
}



























