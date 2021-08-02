package java01748.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 2021/8/2 8:14 下午
 * @Description:
 * 1748. Sum of Unique Elements
 * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
 *
 * Return the sum of all the unique elements of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,2]
 * Output: 4
 * Explanation: The unique elements are [1,3], and the sum is 4.
 * Example 2:
 *
 * Input: nums = [1,1,1,1,1]
 * Output: 0
 * Explanation: There are no unique elements, and the sum is 0.
 * Example 3:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 15
 * Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * Runtime: 1 ms, faster than 72.18% of Java online submissions for Sum of Unique Elements.
 * Memory Usage: 36.6 MB, less than 56.77% of Java online submissions for Sum of Unique Elements.
 */
class Solution {
    public int sumOfUnique(int[] nums) {

        Map<Integer, Integer> help = new HashMap<>();;

        int sum = 0;
        for (int num: nums) {
            help.put(num, help.getOrDefault(num, 0) + 1);
            sum += num;
        }

        for (Map.Entry<Integer, Integer> e : help.entrySet()) {
            if (e.getValue() > 1) {
                sum -= e.getKey() * e.getValue();
            }
        }

        return sum;
    }
}
