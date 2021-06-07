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
 * Time Complexity: O(n * (sum - target))
 * Space Complexity: O(n*negative)
 *
 * dp
 *
 */
class Solution4 {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        int different = sum - target;

        if (different < 0 || different % 2 != 0) {
            return 0;
        }

        int len = nums.length;
        int negative = different / 2;

        int[][] help = new int[len + 1][negative + 1];

        help[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= negative; j++) {
                help[i][j] = help[i - 1][j];
                if (j >= num) {
                    help[i][j] += help[i - 1][j - num];
                }
            }
        }

        return help[len][negative];
    }
}
