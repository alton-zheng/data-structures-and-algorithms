package java01957.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/8 9:04 上午
 * @Description:
 *
 * 1957. Delete Characters to Make Fancy String #282
 *A fancy string is a string where no three consecutive characters are equal.
 *
 * Given a string s, delete the minimum possible number of characters from s to make it fancy.
 *
 * Return the final string after the deletion. It can be shown that the answer will always be unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leeetcode"
 * Output: "leetcode"
 * Explanation:
 * Remove an 'e' from the first group of 'e's to create "leetcode".
 * No three consecutive characters are equal, so return "leetcode".
 * Example 2:
 *
 * Input: s = "aaabaaaa"
 * Output: "aabaa"
 * Explanation:
 * Remove an 'a' from the first group of 'a's to create "aabaaaa".
 * Remove two 'a's from the second group of 'a's to create "aabaa".
 * No three consecutive characters are equal, so return "aabaa".
 * Example 3:
 *
 * Input: s = "aab"
 * Output: "aab"
 * Explanation: No three consecutive characters are equal, so return "aab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists only of lowercase English letters.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 */
class Solution {
    public String makeFancyString(String s) {


        char[] source = s.toCharArray();
        int len = s.length();

        if (len < 3) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        res.append(source[0]);
        res.append(source[1]);

        for (int i = 2; i < len; i++) {
            if (!(source[i] == source[i - 1] && source[i] == source[i - 2])) {
                res.append(source[i]);
            }
        }

        return res.toString();
    }
}
