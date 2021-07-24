package java00665.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/24 下午2:00
 * @Description:
 *
 * 665. Non-decreasing Array #236
 *
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 10^4
 * -10^5 <= nums[i] <= 10^5
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Non-decreasing Array.
 * Memory Usage: 40.5 MB, less than 48.58% of Java online submissions for Non-decreasing Array.
 *
 */
class Solution {
    public boolean checkPossibility(int[] nums) {

        int time = 0;

        for (int i = 0; i < nums.length - 1; i++ ) {
            int cur = nums[i], next = nums[i + 1];

            if (cur > next) {
                time++;

                if (time > 1) {
                    return false;
                }

                if (i > 0 && next < nums[i - 1]) {
                    nums[i + 1] = cur;
                }

            }
        }

        return true;
    }

}
