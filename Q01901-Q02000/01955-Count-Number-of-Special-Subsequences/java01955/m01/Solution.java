package java01955.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/1 5:27 下午
 * @Description:
 * 1955. Count Number of Special Subsequences #262
 *
 * A sequence is special if it consists of a positive number of 0s, followed by a positive number of 1s, then a positive number of 2s.
 *
 * For example, [0,1,2] and [0,0,1,1,1,2] are special.
 * In contrast, [2,1,0], [1], and [0,1,2,0] are not special.
 * Given an array nums (consisting of only integers 0, 1, and 2), return the number of different subsequences that are special. Since the answer may be very large, return it modulo 109 + 7.
 *
 * A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements. Two subsequences are different if the set of indices chosen are different.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,2]
 * Output: 3
 * Explanation: The special subsequences are [0,1,2,2], [0,1,2,2], and [0,1,2,2].
 * Example 2:
 *
 * Input: nums = [2,2,0,0]
 * Output: 0
 * Explanation: There are no special subsequences in [2,2,0,0].
 * Example 3:
 *
 * Input: nums = [0,1,2,0,1,2]
 * Output: 7
 * Explanation: The special subsequences are:
 * - [0,1,2,0,1,2]
 * - [0,1,2,0,1,2]
 * - [0,1,2,0,1,2]
 * - [0,1,2,0,1,2]
 * - [0,1,2,0,1,2]
 * - [0,1,2,0,1,2]
 * - [0,1,2,0,1,2]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 2
 *
 * Time Complexity: O(3N)
 * Space Complexity: O(1)
 */
class Solution {


    public int countSpecialSubsequences(int[] nums) {

        final int MOD = 1000000007;
        int len = nums.length;
        int[][] dp = new int[len + 1][3];

        for (int i = 0; i < len; i++) {
            int cur = nums[i];

            if (cur == 0) {
                dp[i + 1][0] = ((2 * dp[i][0])%MOD + 1)% MOD;
                dp[i + 1][1] = dp[i][1];
                dp[i + 1][2] = dp[i][2];
                continue;
            }

            if (cur == 1) {
                dp[i + 1][0]  = dp[i][0];
                dp[i + 1][1] = (dp[i][0] + (2*dp[i][1])%MOD)% MOD;
                dp[i + 1][2] = dp[i][2];
                continue;
            }

            if (cur == 2) {
                dp[i + 1][0] = dp[i][0];
                dp[i + 1][1] = dp[i][1];
                dp[i + 1][2] = (dp[i][1] + (2*dp[i][2])%MOD)%MOD;
            }
        }

        return dp[len][2];
    }
}
