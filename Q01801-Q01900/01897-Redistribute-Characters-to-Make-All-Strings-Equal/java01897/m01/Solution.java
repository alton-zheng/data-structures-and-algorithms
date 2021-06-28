package java01897.m01;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @Author: alton
 * @Date: Created in 6/28/21 8:56 PM
 * @Description:
 *
 * 1897. Redistribute Characters to Make All Strings Equal #155
 *
 * You are given an array of strings words (0-indexed).
 *
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].
 *
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * to make words[1] = "abc" and words[2] = "abc".
 * All the strings are now equal to "abc", so return true.
 * Example 2:
 *
 * Input: words = ["ab","a"]
 * Output: false
 * Explanation: It is impossible to make all the strings equal using the operation.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 *
 * Time Complexity : O(m + 26)
 * Space COmplexity : O(26)
 *
 * Runtime: 2 ms, faster than 99.60% of Java online submissions for Redistribute Characters to Make All Strings Equal.
 * Memory Usage: 38.7 MB, less than 72.02% of Java online submissions for Redistribute Characters to Make All Strings Equal.
 */
class Solution {
    public boolean makeEqual(String[] words) {

        int[] help = new int[26];

        int len = words.length;

        for (String word: words) {
            for (char c: word.toCharArray()) {
                help[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (help[i] % len != 0) {
                return false;
            }
        }
        return true;
    }
}
