package java00506;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: alton
 * @Date: Created in 6/5/21 4:49 PM
 * @Description:
 *
 * 506. Relative Ranks #77
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
 *
 * The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
 *
 * The 1st place athlete's rank is "Gold Medal".
 * The 2nd place athlete's rank is "Silver Medal".
 * The 3rd place athlete's rank is "Bronze Medal".
 * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 *
 *
 *
 * Example 1:
 *
 * Input: score = [5,4,3,2,1]
 * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 * Example 2:
 *
 * Input: score = [10,3,8,9,4]
 * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 *
 *
 *
 * Constraints:
 *
 * n == score.length
 * 1 <= n <= 10^4
 * 0 <= score[i] <= 10^6
 * All the values in score are unique.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(max(score) + 1)
 *
 * Runtime: 2 ms, faster than 99.77% of Java online submissions for Relative Ranks.
 * Memory Usage: 39.9 MB, less than 66.13% of Java online submissions for Relative Ranks.
 *
 *
 */
class Solution {
    public String[] findRelativeRanks(int[] score) {

        int len = score.length;

        int max = 0;
        for (int s: score) {
            max = max >= s ? max : s;
        }

        int[] help = new int[max + 1];

        for (int i = 0; i < len; i++) {
            help[score[i]] = i + 1;
        }

        String[] res = new String[len];
        int rank = 1;
        for (int i = help.length - 1; i >= 0; i--) {
            if (help[i] != 0) {
                switch (rank) {
                    case 1:
                        res[help[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        res[help[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        res[help[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        res[help[i] - 1] = String.valueOf(rank);
                }
                rank++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().findRelativeRanks(new int[]{10,3,8,9,4});
    }
}
