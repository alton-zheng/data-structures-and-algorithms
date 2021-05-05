/**
 * 740. Delete and Earn
 * Given an array nums of integers, you can perform operations on the array.
 *
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 *
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,2]
 * Output: 6
 * Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points.
 * 6 total points are earned.
 * Example 2:
 *
 * Input: nums = [2,2,3,3,3,4]
 * Output: 9
 * Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 *
 * 动态规划解题
 * Time Complexity: O()
 * Space Complexity: O()
 */
class Solution {

    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;

        // 找到数组中的最大值
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }

        // 构建一个最大值加 1 大小的数组, 统计出所有相同数字之和
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }

        // 利用打家劫舍的算法，来处理
        return rob(sum);

    }

    public int rob(int[] nums) {

        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }
}