package java00446.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 2021/8/11 10:52 上午
 * @Description:
 * 446. Arithmetic Slices II - Subsequence
 *
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The answer is guaranteed to fit in 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,4,6,8,10]
 * Output: 7
 * Explanation: All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * Example 2:
 *
 * Input: nums = [7,7,7,7,7]
 * Output: 16
 * Explanation: Any subsequence of this array is arithmetic.
 *
 *
 * Constraints:
 *
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 2^31 - 1
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 *
 * Runtime: 224 ms, faster than 18.63% of Java online submissions for Arithmetic Slices II - Subsequence.
 * Memory Usage: 100 MB, less than 18.63% of Java online submissions for Arithmetic Slices II - Subsequence.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {

        int res = 0;
        int len = nums.length;
        Map<Long, Integer>[] help = new Map[len];

        for (int i = 0; i < len; i++) {
            help[i] = new HashMap<>();
        }

        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                long d = (long) nums[j] - nums[i];
                int cnt = help[i].getOrDefault(d, 0);
                res += cnt;
                help[j].put(d, help[j].getOrDefault(d, 0) + cnt + 1);
            }
        }

        return res;
    }
}
