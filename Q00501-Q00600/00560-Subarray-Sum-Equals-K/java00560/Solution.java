package java00560;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 5/29/21 8:52 AM
 * @Description:
 * 560. Subarray Sum Equals K #54
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 18 ms, faster than 67.65% of Java online submissions for Subarray Sum Equals K.
 * Memory Usage: 41.8 MB, less than 36.54% of Java online submissions for Subarray Sum Equals K.
 * preSum[i] - preSum[j - 1] = k
 */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, preSum = 0;

        // Build a helper map to store the current prefix sum
        Map<Integer, Integer> help = new HashMap<>();
        help.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (help.containsKey(preSum - k)) {
                res += help.get(preSum - k);
            }

            help.put(preSum, help.getOrDefault(preSum, 0) + 1);
        }

        return res;

    }
}


