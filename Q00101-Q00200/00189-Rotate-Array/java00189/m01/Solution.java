package java00189.m01;

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
 * Runtime: 1 ms, faster than 65.26% of Java online submissions for Rotate Array.
 * Memory Usage: 56.4 MB, less than 39.40% of Java online submissions for Rotate Array.
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        k %= len;

        int[] help = new int[len];

        for (int i = 0; i < len; i++) {
            help[(i + k) % len] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = help[i];
        }
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
