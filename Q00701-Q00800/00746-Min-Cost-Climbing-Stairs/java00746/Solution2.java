package java00746;

/**
 * @Author: alton
 * @Date: Created in 5/23/21 9:18 AM
 * @Description:
 * 746. Min Cost Climbing Stairs
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
class Solution2 {
    public int minCostClimbingStairs(int[] cost) {

        int minCost0 = 0;
        int minCost1 = Math.min(cost[0], cost[1]);
        int minCost = 0;
        for (int i = 2; i < cost.length; i++) {
            minCost = Math.min(minCost1 + cost[i], minCost0 + cost[i - 1]);
            minCost0 = minCost1;
            minCost1 = minCost;
        }
        return minCost;
    }
}