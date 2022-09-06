package java00877.m01;

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
 * DP[][]
 * Time Complexity : O(N^2)
 * Space Complexity : O(N^2)
 * Runtime: 4 ms, faster than 56.29% of Java online submissions for Stone Game.
 * Memory Usage: 39.6 MB, less than 30.80% of Java online submissions for Stone Game.
 */
class Solution {
    public boolean stoneGame(int[] piles) {

        // 石头的堆数
        int len = piles.length;

        // dp help 数组，存储先手-后手差值
        int[][] help = new int[len][len];

        // 初始化左上角到右下角对角的石碓数量
        for (int i = 0; i < len; i++) {
            help[i][i] = piles[i];
        }

        // 从二维数组对角右下角往左上角推理
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {

                // 当先手选择 [i],  后手只能在 [i + 1, j] 选择
                // 当先手选择 [j], 后手只能选择 [i, j -1] 选择
                // 为什么要这么求值呢？ 因为可以直接使用已知的 help 数组来求值
                help[i][j] = Math.max(piles[i] - help[i + 1][j], piles[j] - help[i][j - 1]);
            }
        }

        // 大于 0， 赢，小于 0， 输
        return help[0][len - 1] > 0;

    }
}
