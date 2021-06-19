package java01239.m02;

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
 * Space Complexity : O(2^n) ∣Σ∣ It's the sum of the lengths of all the elements of arr
 *
 * iterator and bit operations
 *
 * Runtime: 6 ms, faster than 89.91% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 * Memory Usage: 39.2 MB, less than 30.27% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 *
 */
class Solution {

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        masks.add(0);

        int res = 0;

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

            if (mask == 0) {
                continue;
            }

            for (int i =  0;  i < masks.size(); i++) {
                int cur = masks.get(i);

                if ((mask & cur) == 0) {
                    masks.add(mask | cur);
                    res = Math.max(res, Integer.bitCount(mask | cur));
                }
            }
        }
        return res;

    }
}
