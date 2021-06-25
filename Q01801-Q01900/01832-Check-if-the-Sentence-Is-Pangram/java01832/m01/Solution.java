package java01832.m01;

/**
 * @Author: alton
 * @Date: Created in 6/25/21 4:57 PM
 * @Description:
 *
 * 1832. Check if the Sentence Is Pangram #146
 *
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= sentence.length <= 1000
 * sentence consists of lowercase English letters.
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 1 ms, faster than 88.37% of Java online submissions for Check if the Sentence Is Pangram.
 * Memory Usage: 37.3 MB, less than 48.09% of Java online submissions for Check if the Sentence Is Pangram.
 *
 */
class Solution {
    public boolean checkIfPangram(String sentence) {

        if (sentence.length() < 26) {
            return false;
        }

        int[] res = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            res[sentence.charAt(i) - 'a']++;
        }

        for (int i : res) {
            if (i == 0) {
                return false;
            }
        }

        return true;

    }
}
