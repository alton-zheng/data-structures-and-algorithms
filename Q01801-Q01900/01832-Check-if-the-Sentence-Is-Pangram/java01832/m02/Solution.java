package java01832.m02;

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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check if the Sentence Is Pangram.
 * Memory Usage: 37.2 MB, less than 48.09% of Java online submissions for Check if the Sentence Is Pangram.
 *
 */
class Solution {
    public boolean checkIfPangram(String sentence) {

        if (sentence.length() < 26) {
            return false;
        }

        // 26 字母在一个数字的二进制位上进行模拟
        int res = 0;
        for ( char c : sentence.toCharArray()) {
            res |= 1 << (c - 'a');
            if ((res ^ 0x3ffffff) == 0) {
                return true;
            }
        }

        return false;

    }
}
