package java00525;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 6/3/21 10:24 AM
 * @Description:
 *
 * 525. Contiguous Array
 *
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 * Runtime: 7 ms, faster than 99.67% of Java online submissions for Contiguous Array.
 * Memory Usage: 49.4 MB, less than 9.52% of Java online submissions for Contiguous Array.
 * prefix tree and array
 */
class Solution2 {
    public int findMaxLength(int[] nums) {

        int res = 0, ones = 0, temp = 0, numsLen = nums.length;
        Integer[] help = new Integer[2 * numsLen + 1];
        help[numsLen] = -1;

        for (int i = 0; i < numsLen; i++) {
            temp = nums[i] == 1 ? numsLen + ++ones : numsLen + --ones;
            temp = help[temp] != null ? (res = Math.max(res, i - help[temp])) : (help[temp] = i);
        }

        return res;
    }
}