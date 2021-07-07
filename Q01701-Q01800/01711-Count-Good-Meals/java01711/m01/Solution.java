package java01711.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 7/7/21 9:50 AM
 * @Description:
 * 1711. Count Good Meals #182
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
 *
 * You can pick any two different foods to make a good meal.
 *
 * Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food, return the number of different good meals you can make from this list modulo 109 + 7.
 *
 * Note that items with different indices are considered different even if they have the same deliciousness value.
 *
 *
 *
 * Example 1:
 *
 * Input: deliciousness = [1,3,5,7,9]
 * Output: 4
 * Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
 * Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
 * Example 2:
 *
 * Input: deliciousness = [1,1,1,3,3,3,7]
 * Output: 15
 * Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.
 *
 *
 * Constraints:
 *
 * 1 <= deliciousness.length <= 10^5
 * 0 <= deliciousness[i] <= 2^20
 *
 * Time Complexity : O(N*logC)
 * Space Complexity : O(N)
 *
 * Runtime: 133 ms, faster than 76.46% of Java online submissions for Count Good Meals.
 * Memory Usage: 47.7 MB, less than 98.00% of Java online submissions for Count Good Meals.
 */
class Solution {
    public int countPairs(int[] deliciousness) {

        final int mod = 1000000007;

        int max = 0;

        // 找到 deliciousness 中的最大值
        for (int val : deliciousness) {
            max = Math.max(max, val);
        }

        // 每组餐的最大美味度 = max * 2;
        int maxSum = max * 2;
        int pairs = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int n = deliciousness.length;

        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) >= mod ? (pairs + count) % mod : (pairs + count);
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return pairs;
    }
}
