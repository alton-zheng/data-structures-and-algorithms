package java00413.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/10 9:07 上午
 * @Description:
 * 413. Arithmetic Slices #291
 *
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Arithmetic Slices.
 * Memory Usage: 36.9 MB, less than 37.10% of Java online submissions for Arithmetic Slices.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;

        if (len < 3) {
            return 0;
        }

        int slices = 0;
        int cnt = 2;
        int pre = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            int temp = nums[i] - nums[i - 1];
            if (temp == pre) {
                cnt++;
                slices += cnt == 3 ? 1 : cnt - 2;
            } else {
                cnt = 2;
                pre = temp;
            }
        }

        return slices;
    }
}
