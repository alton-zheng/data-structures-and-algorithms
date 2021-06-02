package java00053;

/**
 * @Author: alton
 * @Date: Created in 6/2/21 9:57 PM
 * @Description:
 * 53. Maximum Subarray #67
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * DP
 *
 * Runtime: 1 ms, faster than 44.36% of Java online submissions for Maximum Subarray.
 * Memory Usage: 38.9 MB, less than 54.72% of Java online submissions for Maximum Subarray.
 */
class Solution2 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];

        for (int cur = 1; cur < nums.length; cur++) {
            dp[cur] = Math.max(nums[cur], dp[cur - 1] + nums[cur]);
            res = Math.max(res, dp[cur]);
        }


        return res;
    }
}
