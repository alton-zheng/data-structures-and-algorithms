package java01027;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 6/3/21 2:06 PM
 * @Description:
 *
 * 1027. Longest Arithmetic Subsequence #69
 *
 * 1027. Longest Arithmetic Subsequence
 * Medium
 *
 * 1331
 *
 * 77
 *
 * Add to List
 *
 * Share
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 *
 * Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ..., nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence seq is arithmetic if seq[i+1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 *
 * Input: nums = [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 *
 * Input: nums = [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(2*M*n)
 * Runtime: 101 ms, faster than 80.57% of Java online submissions for Longest Arithmetic Subsequence.
 * Memory Usage: 85.9 MB, less than 8.20% of Java online submissions for Longest Arithmetic Subsequence.
 */
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int numsLen = nums.length, res = 2;
        int max = 0;
        for (int i = 0 ; i < numsLen; i++) {
            max = Math.max(max, nums[i]);
        }


        int[][] dp = new int[numsLen][max * 2 + 2];

        for (int i = 0; i < numsLen; i++) {

            for (int j = i - 1; j >= 0; j--) {

                int diff = nums[i] - nums[j] + max;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] != 0 ? dp[j][diff] + 1 : 2);
                res = Math.max(res, dp[i][diff]);
            }
        }

        return res;
    }
}
