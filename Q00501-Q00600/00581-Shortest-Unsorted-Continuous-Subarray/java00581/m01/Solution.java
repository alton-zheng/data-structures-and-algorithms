package java00581.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/3 9:37 上午
 * @Description:
 *
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int len = nums.length;

        int left = -1, right = -1;
        int max = -100001, min = 100001;

        for (int i = 0; i < len; i++) {
            if (max <= nums[i]) {
                max = nums[i];
            } else {
                right = i;
            }

            if (min >= nums[len - i - 1]) {
                min = nums[len - i - 1];
            } else {
                left = len - i - 1;
            }
        }

        return left == -1 ? 0 : right - left + 1;

    }
}
