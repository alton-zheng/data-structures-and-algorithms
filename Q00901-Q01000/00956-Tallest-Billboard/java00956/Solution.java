package java00956;

/**
 * @Author: alton
 * @Date: Created in 5/31/21 8:53 AM
 * @Description:
 *
 * 956. Tallest Billboard #60
 *
 * You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.
 *
 * You are given a collection of rods that can be welded together. For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
 *
 * Return the largest possible height of your billboard installation. If you cannot support the billboard, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: rods = [1,2,3,6]
 * Output: 6
 * Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
 * Example 2:
 *
 * Input: rods = [1,2,3,4,5,6]
 * Output: 10
 * Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
 * Example 3:
 *
 * Input: rods = [1,2]
 * Output: 0
 * Explanation: The billboard cannot be supported, so we return 0.
 *
 *
 * Constraints:
 *
 * 1 <= rods.length <= 20
 * 1 <= rods[i] <= 1000
 * sum(rods[i]) <= 5000
 *
 * Time Complexity: O()
 * Space Complexity: O()
 *
 * DP solve
 * Runtime: 30 ms, faster than 56.60% of Java online submissions for Tallest Billboard.
 * Memory Usage: 45.2 MB, less than 17.92% of Java online submissions for Tallest Billboard.
 *
 */
class Solution {

    Integer[][] help;
    public int tallestBillboard(int[] rods) {

        help = new Integer[rods.length][10001];

        // sum(rods[i]) <= 5000
        return getTallestBillboard(rods, 0, 5000);
    }

    private int getTallestBillboard(int[] rods, int curIndex, int sum) {

        if (curIndex == rods.length) {
            return sum == 5000 ? 0 : Integer.MIN_VALUE;
        }

        if (help[curIndex][sum] != null) {
            return help[curIndex][sum];
        }

        int res = getTallestBillboard(rods, curIndex + 1, sum);
        res = Math.max(res, getTallestBillboard(rods, curIndex + 1, sum + rods[curIndex]));
        res = Math.max(res, rods[curIndex]  + getTallestBillboard(rods, curIndex + 1, sum - rods[curIndex]));
        help[curIndex][sum] = res;
        return res;

    }

}
