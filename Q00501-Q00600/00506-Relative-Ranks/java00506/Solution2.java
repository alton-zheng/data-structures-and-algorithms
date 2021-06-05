package java00506;

import java.util.Arrays;

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
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * All the values in score are unique.
 *
 * Time Complexity: O(N + N^2 + Nlogn)
 * Space Complexity: O(n)
 * sort + binary search
 *
 * Runtime: 3 ms, faster than 97.22% of Java online submissions for Relative Ranks.
 * Memory Usage: 40.2 MB, less than 31.79% of Java online submissions for Relative Ranks.
 */
class Solution2 {
    public String[] findRelativeRanks(int[] score) {

        int len = score.length;
        int[] copy = Arrays.copyOf(score, len);
        Arrays.sort(copy);
        String[] res = new String[len];

        for (int i = 0; i < score.length; i++) {

            int rank = len - Arrays.binarySearch(copy, score[i]);

            switch (rank) {
                case 1:
                    res[i] = "Gold Medal";
                    break;
                case 2:
                    res[i] = "Silver Medal";
                    break;
                case 3:
                    res[i] = "Bronze Medal";
                    break;
                default:
                    res[i] = String.valueOf(rank);
            }
        }

        return res;


    }
}
