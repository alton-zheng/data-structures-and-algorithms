package java01962.m01;

import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 2021/8/8 3:32 下午
 * @Description:
 * 1962. Remove Stones to Minimize the Total #285
 *
 * You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:
 *
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
 * Notice that you can apply the operation on the same pile more than once.
 *
 * Return the minimum possible total number of stones remaining after applying the k operations.
 *
 * floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [5,4,9], k = 2
 * Output: 12
 * Explanation: Steps of a possible scenario are:
 * - Apply the operation on pile 2. The resulting piles are [5,4,5].
 * - Apply the operation on pile 0. The resulting piles are [3,4,5].
 * The total number of stones in [3,4,5] is 12.
 * Example 2:
 *
 * Input: piles = [4,3,6,7], k = 3
 * Output: 12
 * Explanation: Steps of a possible scenario are:
 * - Apply the operation on pile 3. The resulting piles are [4,3,3,7].
 * - Apply the operation on pile 4. The resulting piles are [4,3,3,4].
 * - Apply the operation on pile 0. The resulting piles are [2,3,3,4].
 * The total number of stones in [2,3,3,4] is 12.
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 105
 * 1 <= piles[i] <= 104
 * 1 <= k <= 105
 *
 * Time Complexity: O(n + k logn)
 * Space Compleixty: O(n)
 *
 * 竞赛题
 */
class Solution {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
        }

        while (!queue.isEmpty() && k > 0) {
            int maxValue = queue.poll();
            int item = maxValue - maxValue / 2;
            queue.add(item);
            k--;
        }

        int res = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            res += queue.poll();
        }

        return res;

    }
}
