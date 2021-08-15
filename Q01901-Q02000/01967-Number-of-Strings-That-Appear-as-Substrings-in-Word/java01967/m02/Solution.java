package java01967.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/8/15 下午4:04
 * @Description:
 *
 * 1967. Number of Strings That Appear as Substrings in Word #309
 * Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: patterns = ["a","abc","bc","d"], word = "abc"
 * Output: 3
 * Explanation:
 * - "a" appears as a substring in "abc".
 * - "abc" appears as a substring in "abc".
 * - "bc" appears as a substring in "abc".
 * - "d" does not appear as a substring in "abc".
 * 3 of the strings in patterns appear as a substring in word.
 * Example 2:
 *
 * Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
 * Output: 2
 * Explanation:
 * - "a" appears as a substring in "aaaaabbbbb".
 * - "b" appears as a substring in "aaaaabbbbb".
 * - "c" does not appear as a substring in "aaaaabbbbb".
 * 2 of the strings in patterns appear as a substring in word.
 * Example 3:
 *
 * Input: patterns = ["a","a","a"], word = "ab"
 * Output: 3
 * Explanation: Each of the patterns appears as a substring in word "ab".
 *
 *
 * Constraints:
 *
 * 1 <= patterns.length <= 100
 * 1 <= patterns[i].length <= 100
 * 1 <= word.length <= 100
 * patterns[i] and word consist of lowercase English letters.
 * Time Complexity: O(n×∑_im_i)
 * Space Complexity: O(1)
 * 竞赛中用了 api, 偷懒了，底层本质上为 KMP 算法，后续再了解
 * 了解的时候实现下 28 题，可以使用 KMP 算法实现
 */
// TODO: 2021/8/15 实现下 KMP 算法， 1967 以及 28 题
class Solution {

    public int numOfStrings(String[] patterns, String word) {

        int res = 0;
        for (String pattern: patterns) {
            res += word.contains(pattern) ? 1 : 0;
        }

        return res;
    }

}
