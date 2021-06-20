package java00846.m01;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: alton
 * @Date: Created in 6/20/21 12:43 PM
 * @Description:
 * 846. Hand of Straights #132
 *
 * Alice has a hand of cards, given as an array of integers.
 *
 * Now she wants to rearrange the cards into groups so that each group is size groupSize, and consists of groupSize consecutive cards.
 *
 * Return true if and only if she can.
 *
 * Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 *
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 *
 *
 *
 * Constraints:
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 *
 * Time Complexity : O(N*logN)
 * Space Complexity : O(N)
 *
 * Runtime: 53 ms, faster than 41.29% of Java online submissions for Hand of Straights.
 * Memory Usage: 39.3 MB, less than 97.18% of Java online submissions for Hand of Straights.
 */
class Solution {
    public boolean isNStraightHand(int[] hands, int groupSize) {

        TreeMap<Integer, Integer> help = new TreeMap<>();

        Arrays.sort(hands);

        for (int num : hands) {
            help.put(num, help.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m : help.entrySet()) {
            if (m.getValue() > 0) {

                for (int i = m.getKey() + 1; i < m.getKey() + groupSize; i++) {

                    if (help.getOrDefault(i, 0) > m.getValue() - 1) {
                        help.put(i, help.get(i) - m.getValue());
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;

    }
}
