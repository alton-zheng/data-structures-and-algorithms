package java01446.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/27 6:05 下午
 * @Description:
 *
 * 1446. Consecutive Characters
 *
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Given a string s, return the power of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * Example 3:
 *
 * Input: s = "triplepillooooow"
 * Output: 5
 * Example 4:
 *
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * Example 5:
 *
 * Input: s = "tourist"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 *
 * Runtime: 3 ms, faster than 13.85% of Java online submissions for Consecutive Characters.
 * Memory Usage: 39.5 MB, less than 5.97% of Java online submissions for Consecutive Characters.
 */
class Solution {
    public int maxPower(String s) {
        int res = 1;
        int cnt = 1;
        int pre = s.charAt(0);


        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                cnt++;
            } else {
                cnt = 1;
                pre = s.charAt(i);
            }
            res = Math.max(res, cnt);
        }

        return res;
    }
}
