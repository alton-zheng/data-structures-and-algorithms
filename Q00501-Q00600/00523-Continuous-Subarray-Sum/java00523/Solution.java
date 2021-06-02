package java00523;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 6/2/21 5:10 PM
 * @Description:
 *
 * 523. Continuous Subarray Sum #66
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * Example 2:
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * Example 3:
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * Time Complexity : O(n)
 * Space Complexity: O(min(n, k))
 * Runtime: 14 ms, faster than 94.20% of Java online submissions for Continuous Subarray Sum.
 * Memory Usage: 55.9 MB, less than 8.30% of Java online submissions for Continuous Subarray Sum.
 *
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int numsLen = nums.length;
        if (numsLen < 2) {
            return false;
        }
        Map<Integer, Integer> help = new HashMap<>();
        help.put(0, -1);
        int remainder = 0;

        for (int i = 0; i < numsLen; i++) {

            remainder = (remainder + nums[i]) % k;
            if (help.containsKey(remainder)) {
                if (i - help.get(remainder) > 1) {
                    return true;
                }
            } else {
                help.put(remainder, i);
            }
        }

        return false;
    }

}
