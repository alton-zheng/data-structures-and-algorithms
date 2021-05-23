package java00746;

/**
 * @Author: alton
 * @Date: Created in 5/23/21 9:18 AM
 * @Description:
 * 746. Min Cost Climbing Stairs #35
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
 * Example 2:
 * <p>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i] = (Math.min(cost[i - 2], cost[i - 1]))  + cost[i];
        }

        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);

    }
}