package java00877.m02;

/**
 * @Author: alton
 * @Date: Created in 6/16/21 8:14 AM
 * @Description:
 * 877. Stone Game #115
 *
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 *
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 *
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 *
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [5,3,4,5]
 * Output: true
 * Explanation:
 * Alex starts first, and can only take the first 5 or the last 5.
 * Say he takes the first 5, so that the row becomes [3, 4, 5].
 * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 *
 *
 * Constraints:
 *
 * 2 <= piles.length <= 500
 * piles.length is even.
 * 1 <= piles[i] <= 500
 * sum(piles) is odd.
 *
 *
 * DP[] -> opt Space Complexity
 * Time Complexity : O(N^2)
 * Space Complexity : O(N)
 * Runtime: 3 ms, faster than 59.63% of Java online submissions for Stone Game.
 * Memory Usage: 36.7 MB, less than 75.44% of Java online submissions for Stone Game.
 */
class Solution {
    public boolean stoneGame(int[] piles) {

        // 石头的堆数
        int len = piles.length;

        //
        int[] help = new int[len];

        for (int i = 0; i < len; i++) {
            help[i] = piles[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                help[j] = Math.max(piles[i] - help[j], piles[j] - help[j - 1]);
            }
        }

        return help[len - 1] > 0;

    }
}
