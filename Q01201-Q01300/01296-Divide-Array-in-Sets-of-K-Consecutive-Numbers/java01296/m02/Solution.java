package java01296.m02;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/20/21 9:17 AM
 * @Description:
 *
 * 1296. Divide Array in Sets of K Consecutive Numbers #131
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if it is possible. Otherwise, return False.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 * Example 2:
 *
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 * Example 3:
 *
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 * Example 4:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 *
 * Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/
 *
 * Time Complexity : O(LogN)
 * Space Complexity : O(N)
 *
 * Runtime: 252 ms, faster than 20.85% of Java online submissions for Divide Array in Sets of K Consecutive Numbers.
 * Memory Usage: 80.9 MB, less than 8.18% of Java online submissions for Divide Array in Sets of K Consecutive Numbers.

 */
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        TreeMap<Integer, Integer> help = new TreeMap<>();

        Arrays.sort(nums);

        for (int num: nums){
            help.put(num, help.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m: help.entrySet()) {
            if (m.getValue() > 0) {

                for (int i = m.getKey() + 1; i < m.getKey() + k; i++) {

                    if (help.getOrDefault(i, 0) > m.getValue() - 1) {
                        help.put(i, help.get(i) - m.getValue());
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;

    }
}
