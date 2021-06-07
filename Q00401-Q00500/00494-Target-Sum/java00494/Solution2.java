package java00494;

/**
 * @Author: alton
 * @Date: Created in 6/7/21 10:40 AM
 * @Description:
 *
 * 494. Target Sum #83
 *
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * backtracking
 *
 */
class Solution2 {

    public int findTargetSumWays(int[] nums, int target) {

        return getTargetSumWays(nums, target, 0, 0);

    }

    private int getTargetSumWays(int[] nums, int target, int index,  int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return getTargetSumWays(nums, target, index + 1, sum + nums[index])
                + getTargetSumWays(nums, target, index + 1, sum - nums[index]);
    }
}
