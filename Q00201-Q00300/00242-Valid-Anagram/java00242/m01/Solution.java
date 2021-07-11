package java00242.m01;

/**
 * @Author: alton
 * @Date: Created in 7/11/21 3:47 PM
 * @Description:
 * 242. Valid Anagram #196
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] help = new int[26];

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            help[sc[i] - 'a']++;
            help[tc[i] - 'a']--;
        }

        for (int num : help) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
