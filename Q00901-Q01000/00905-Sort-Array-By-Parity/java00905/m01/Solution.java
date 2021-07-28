package java00905.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/28 9:25 下午
 * @Description:
 * 905. Sort Array By Parity
 *
 * Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * Runtime: 1 ms, faster than 99.05% of Java online submissions for Sort Array By Parity.
 * Memory Usage: 40 MB, less than 36.01% of Java online submissions for Sort Array By Parity.
 *
 */
class Solution {
    public int[] sortArrayByParity(int[] nums) {

        // 定义数组长度
        int len = nums.length;

        // 定义双指针， left, right
        // left 用来指向奇数位置
        // right 用来指向偶数位置
        int left = 0, right = nums.length - 1;
        do {
            // 交互奇偶位置
            swap(nums, left, right);
            // 找到奇数位置 left
            while (left < len && nums[left] %2 != 1) {
                left++;
            }

            // 找到偶数位置 right
            while (right > 0 && nums[right] %2 != 0) {
                right--;
            }

        } while (left < right);

        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int swap = nums[left];
        nums[left] = nums[right];
        nums[right] = swap;
    }
}
