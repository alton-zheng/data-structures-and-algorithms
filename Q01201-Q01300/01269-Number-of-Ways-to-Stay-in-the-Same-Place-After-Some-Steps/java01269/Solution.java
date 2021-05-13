package java01269;

/**
 * @Author: alton
 * @Date: Created in 5/13/21 8:50 AM
 * @Description:
 * 1269. Number of Ways to Stay in the Same Place After Some Steps
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array or stay in the same place  (The pointer should not be placed outside the array at any time).
 *
 * Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: steps = 3, arrLen = 2
 * Output: 4
 * Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 * Right, Left, Stay
 * Stay, Right, Left
 * Right, Stay, Left
 * Stay, Stay, Stay
 * Example 2:
 *
 * Input: steps = 2, arrLen = 4
 * Output: 2
 * Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 * Right, Left
 * Stay, Stay
 * Example 3:
 *
 * Input: steps = 4, arrLen = 2
 * Output: 8
 *
 *
 * Constraints:
 *
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 *
 * DP 注意边界问题，避免越界
 * Time Complexity: O(steps * min(arrLen,steps))
 * Space Complexity: O(min(arrLen,steps))
 */
class Solution {
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[] dp = new int[maxColumn + 1];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] dpNext = new int[maxColumn + 1];
            for (int j = 0; j <= maxColumn; j++) {
                dpNext[j] = dp[j];
                if (j - 1 >= 0) {
                    dpNext[j] = (dpNext[j] + dp[j - 1]) % MODULO;
                }
                if (j + 1 <= maxColumn) {
                    dpNext[j] = (dpNext[j] + dp[j + 1]) % MODULO;
                }

                // 因为只需要统计到原点的补数，走最后一步时，仅需要关注走到原点的可能步数即可。
                if (i == steps && j == 0) {
                    break;
                }
            }
            dp = dpNext;
        }
        return dp[0];
    }

    public static void main(String[] args) {

        System.out.println(new Solution().numWays(2, 2));

    }
}