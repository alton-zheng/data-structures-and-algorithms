package java00560;

/**
 * @Author: alton
 * @Date: Created in 5/29/21 8:52 AM
 * @Description:
 * 560. Subarray Sum Equals K #54
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * Time Complexity: O(n(1 + n))
 * Space Complexity: O(1)
 * Runtime: 1227 ms, faster than 18.86% of Java online submissions for Subarray Sum Equals K.
 * Memory Usage: 41 MB, less than 93.77% of Java online submissions for Subarray Sum Equals K.
 * Reverse order Iterate all continuous subarrays
 */
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
