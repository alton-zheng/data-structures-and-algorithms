package java00031.m01;

/**
 * @Author: alton
 * @Date: Created in 6/22/21 9:31 PM
 * @Description:
 *
 * 31. Next Permutation #137
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
 * Memory Usage: 39.5 MB, less than 17.78% of Java online submissions for Next Permutation.
 *
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;

        int left = len - 2;

        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        if (left > -1) {
            int right = len - 1;
            while (right >= 0 && nums[left] >= nums[right]) {
                right--;
            }

            swap(nums, left, right);
        }

        reverse(nums, left + 1, len - 1);

    }

    private void swap(int[] nums, int left, int right) {
        int swap = nums[left];
        nums[left] = nums[right];
        nums[right] = swap;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
