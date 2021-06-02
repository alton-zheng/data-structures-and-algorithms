package java00283;

import java.util.ArrayList;
import java.util.List;

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
 * Time Complexity: O(2n)
 * Space Complexity: O(n)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
 * Memory Usage: 39.1 MB, less than 72.52% of Java online submissions for Move Zeroes.

 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        int[] help = new int[nums.length];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                help[cur++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = help[i];
        }
    }
}
