package java00747.m01;

/**
 * @Author: alton
 * @Date: Created in 7/14/21 4:18 PM
 * @Description:
 *
 * 747. Largest Number At Least Twice of Others #207
 *
 * You are given an integer array nums where the largest integer is unique.
 *
 * Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: -1
 * Explanation: 4 is less than twice the value of 3, so we return -1.
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 0
 * Explanation: 1 is trivially at least twice the value as any other number because there are no other numbers.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * The largest element in nums is unique.
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Number At Least Twice of Others.
 * Memory Usage: 36.6 MB, less than 85.79% of Java online submissions for Largest Number At Least Twice of Others.
 *
 */
class Solution {
    public int dominantIndex(int[] nums) {

        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }

        for (int num : nums) {
            if (num != max) {
                if (max < num * 2) {
                    return -1;
                }
            }
        }

        return idx;
    }
}
