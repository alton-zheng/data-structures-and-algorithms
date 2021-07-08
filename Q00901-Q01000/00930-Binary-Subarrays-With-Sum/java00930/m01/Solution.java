package java00930.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 7/8/21 8:40 AM
 * @Description:
 * 930. Binary Subarrays With Sum #185
 *
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * Example 2:
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 *
 * Time Complexity : O(N)
 * Space Complexity: O(N)
 * Runtime: 16 ms, faster than 42.49% of Java online submissions for Binary Subarrays With Sum.
 * Memory Usage: 43.6 MB, less than 26.30% of Java online submissions for Binary Subarrays With Sum.
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;

        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{1, 2, 1, 2, 1, 2}, 3));
    }
}
