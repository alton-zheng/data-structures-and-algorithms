package java01140;

/**
 * @Author: alton
 * @Date: Created in 5/15/21 10:53 AM
 * @Description: 1140. Stone Game II #9
 * Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
 * <p>
 * Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
 * <p>
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * <p>
 * The game continues until all the stones have been taken.
 * <p>
 * Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 * Example 2:
 * <p>
 * Input: piles = [1,2,3,4,5,100]
 * Output: 104
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 104
 * <p>
 * Time Complexity: O(x * n^2)
 * Space Complexity: O(1)
 */
class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len + 1];

        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                    }
                }
            }
        }

        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] piles = new int[]{2,7,9,4,4};
        new Solution().stoneGameII(piles);
    }
}
