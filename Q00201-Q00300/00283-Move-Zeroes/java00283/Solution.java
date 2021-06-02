package java00283;

/**
 * @Author: alton
 * @Date: Created in 6/2/21 10:41 PM
 * @Description:
 * 283. Move Zeroes #68
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
 * Memory Usage: 41.6 MB, less than 5.03% of Java online submissions for Move Zeroes.

 */
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, numsLen = nums.length;

        for (int i = 0; i < numsLen; i++) {

            if (nums[i] != 0) {
                if (left != right) {
                    swap(nums, left, right);
                }
                left++;
            }

            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int swap = nums[right];
        nums[right] = nums[left];
        nums[left] = swap;
    }
}
