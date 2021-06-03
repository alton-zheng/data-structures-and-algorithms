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
 * Runtime: 36 ms, faster than 6.99% of Java online submissions for Contiguous Array.
 * Memory Usage: 99.4 MB, less than 5.56% of Java online submissions for Contiguous Array.
 * prefix tree and hash
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int ones = 0;
        Map<Integer, Integer> help = new HashMap<>();
        help.put(0, -1);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                ones++;
            } else {
                ones--;
            }

            if (help.containsKey(ones)) {
                res = Math.max(res, i - help.get(ones));
            } else {
                help.put(ones, i);
            }
        }

        return res;
    }
}
