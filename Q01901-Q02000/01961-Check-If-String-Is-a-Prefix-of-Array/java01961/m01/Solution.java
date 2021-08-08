package java01961.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/8 3:20 下午
 * @Description:
 *
 * 1961. Check If String Is a Prefix of Array
 *
 * Given a string s and an array of strings words, determine whether s is a prefix string of words.
 *
 * A string s is a prefix string of words if s can be made by concatenating the first k strings in words for some positive k no larger than words.length.
 *
 * Return true if s is a prefix string of words, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "iloveleetcode", words = ["i","love","leetcode","apples"]
 * Output: true
 * Explanation:
 * s can be made by concatenating "i", "love", and "leetcode" together.
 * Example 2:
 *
 * Input: s = "iloveleetcode", words = ["apples","i","love","leetcode"]
 * Output: false
 * Explanation:
 * It is impossible to make s using a prefix of arr.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * 1 <= s.length <= 1000
 * words[i] and s consist of only lowercase English letters.
 *
 * Time Complexity: O(min(len(s), len(word)))
 * Space Complexity: O(1)
 *
 * Runtime: 1 ms, faster than 66.67% of Java online submissions for Check If String Is a Prefix of Array.
 * Memory Usage: 39.1 MB, less than 66.67% of Java online submissions for Check If String Is a Prefix of Array.
 */
class Solution {
    public boolean isPrefixString(String s, String[] words) {

        int len = s.length();

        int cur = 0;
        for (String word: words) {
            for (char w: word.toCharArray()) {
                if (cur < len && w == s.charAt(cur)) {
                    cur++;
                } else {
                    return false;
                }
            }

            if (cur == len) {
                return true;
            }
        }

        return false;
    }
}
