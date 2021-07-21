package java00189.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/7/21 下午12:19
 * @Description:
 * 189. Rotate Array #229
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 10^5
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
 * Memory Usage: 56 MB, less than 82.07% of Java online submissions for Rotate Array.
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);


    }

    private void reverse(int[] arr, int start, int end) {

        while (start < end) {
            int swap = arr[start];
            arr[start++] = arr[end];
            arr[end--] = swap;
        }

    }

}
