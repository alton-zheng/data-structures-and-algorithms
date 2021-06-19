package java01239.m01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 6/19/21 8:07 AM
 * @Description:
 *
 * 1239. Maximum Length of a Concatenated String with Unique Characters #125
 *
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 *
 *
 * Time Complexity : O(∣Σ∣+2^n) ∣Σ∣ It's the sum of the lengths of all the elements of arr
 * Space Complexity : O(∣Σ∣+2^n) ∣Σ∣ It's the sum of the lengths of all the elements of arr
 *
 * Backtracking and bit operations
 *
 * Runtime: 2 ms, faster than 98.48% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 * Memory Usage: 36.5 MB, less than 95.99% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 *
 */
class Solution {

    private int res = 0;
    private List<Integer> masks;
    public int maxLength(List<String> arr) {
        masks = new ArrayList<>();

        for (String s: arr) {
            int mask = 0;
            for (char c: s.toCharArray()) {
                c -= 'a';

                if (((mask >> c) & 1) != 0) {
                    mask = 0;
                    break;
                }

                mask |= 1 << c;
            }

            if (mask > 0) {
                masks.add(mask);
            }
        }
        backtrace(0, 0);
        return res;

    }

    private void backtrace (int pos, int mask) {

        if (pos == masks.size()) {
            res = Math.max(res, Integer.bitCount(mask));
            return;
        }

        if ((masks.get(pos) & mask) == 0) {
            backtrace(pos + 1, mask | masks.get(pos));
        }

        backtrace(pos + 1, mask);
    }
}
