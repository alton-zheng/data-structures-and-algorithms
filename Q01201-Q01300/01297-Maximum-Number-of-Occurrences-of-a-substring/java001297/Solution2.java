package java001297;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/11/21 12:47 PM
 * @Description:
 *
 * 1297. Maximum Number of Occurrences of a Substring #99
 *
 * Given a string s, return the maximum number of ocurrences of any substring under the following rules:
 *
 * The number of unique characters in the substring must be less than or equal to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 *
 *
 * Example 1:
 *
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 ocurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 * Example 2:
 *
 * Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * Output: 2
 * Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 * Example 3:
 *
 * Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * Output: 3
 * Example 4:
 *
 * Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s only contains lowercase English letters.
 *
 * Time Complexity: O(NS)
 * Space Complexity : O(NS)
 * Runtime: 59 ms, faster than 33.29% of Java online submissions for Maximum Number of Occurrences of a Substring.
 * Memory Usage: 41.6 MB, less than 46.97% of Java online submissions for Maximum Number of Occurrences of a Substring.
 *
 */
class Solution2 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int sLen = s.length();
        Map<String, Integer> help = new HashMap<>();

        int res = 0;

        for (int i = 0; i < sLen - minSize + 1; i++) {

            String temp = s.substring(i, i + minSize);
            Set<Character> set = new HashSet<>();
            for (int j = i; j < i + minSize; j++) {
                set.add(s.charAt(j));
            }

            if (set.size() <= maxLetters) {
                help.put(temp, help.getOrDefault(temp, 0) + 1);
                res = Math.max(res, help.getOrDefault(temp, 0));
            }
        }

        return res;
    }
}
