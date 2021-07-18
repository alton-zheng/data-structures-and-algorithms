package java01456.m01;

/**
 * @Author: alton
 * @Date: Created in 7/18/21 10:20 AM
 * @Description:
 *
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * Given a string s and an integer k.
 *
 * Return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are (a, e, i, o, u).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * Example 4:
 *
 * Input: s = "rhythms", k = 4
 * Output: 0
 * Explanation: We can see that s doesn't have any vowel letters.
 * Example 5:
 *
 * Input: s = "tryhard", k = 4
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
 * Memory Usage: 39.7 MB, less than 32.71% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
 */
class Solution {

    public int maxVowels(String s, int k) {

        char[] sChar = s.toCharArray();
        int len = sChar.length;

        int[] help = new int[26];
        help[0] = help['e' - 'a'] = help['i' - 'a'] = help['o' - 'a'] = help['u' - 'a'] = 1;

        int res = 0;

        for (int i = 0; i <= k - 1; i++) {
            res += help[sChar[i] - 'a'];
        }

        int idx = 0;
        int pre = res;

        for (int i = k; i < len; i++) {
            pre += help[sChar[i] - 'a'] - help[sChar[idx] - 'a'];
            res = Math.max(res, pre);
            idx++;
        }

        return res;
    }
}
