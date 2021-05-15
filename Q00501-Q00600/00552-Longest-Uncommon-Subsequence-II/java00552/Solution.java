package java00552;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: alton
 * @Date: Created in 5/15/21 8:26 AM
 * @Description:
 * 522. Longest Uncommon Subsequence II
 *
 * Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.
 * An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.
 * A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.
 * For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 *
 * Example 1:
 * Input: strs = ["aba","cdc","eae"]
 * Output: 3
 * Example 2:
 *
 * Input: strs = ["aaa","aaa","aa"]
 * Output: -1
 *
 * Constraints:
 *
 * 1 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] consists of lowercase English letters.
 *
 * Time Complexity: O(x * n^2)
 * Space Complexity: O(1)
 */
public class Solution {

    public int findLUSlength(String[] strs) {

        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

        for (int i = 0; i < strs.length; i++) {

            char flag = '1';

            for (int j = 0; j < strs.length; j++) {

                if (i == j) {
                    continue;
                }

                if (isSubquence(strs[i], strs[j])) {
                    flag = '0';
                    break;
                }
            }

            if (flag == '1') {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean isSubquence(String a, String b) {

        int i = 0;
        for (int j = 0; j < b.length() && i < a.length(); j++) {

            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
        }

        return i == a.length();
    }
}
