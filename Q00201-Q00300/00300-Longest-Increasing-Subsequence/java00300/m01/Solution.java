package java00300.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/26 8:10 下午
 * @Description:
 * 300. Longest Increasing Subsequence #242
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 * Runtime: 58 ms, faster than 55.50% of Java online submissions for Longest Increasing Subsequence.
 * Memory Usage: 38.9 MB, less than 48.37% of Java online submissions for Longest Increasing Subsequence.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {

        // 定义 len , nums 的长度
        int len = nums.length;

        // 定义 dp , 长度为 len
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            // 因为元素本身长度为 1， 因此最短也是 1
            dp[i] = 1;
            // 从 i 开始往前找
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // dp [i] 等于所有比 nums[i] 小的位置的 dp[j] + 1
                    // 取其最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // 取最大的 dp 值
            res = Math.max(res, dp[i]);
        }

        // 返回结果
        return res;
    }
}
