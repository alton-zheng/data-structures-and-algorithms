package java00945.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/6 3:32 下午
 * @Description:
 * 945. Minimum Increment to Make Array Unique
 *
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 *
 * Return the minimum number of moves to make every value in nums unique.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: 1
 * Explanation: After 1 move, the array could be [1, 2, 3].
 * Example 2:
 *
 * Input: nums = [3,2,1,2,1,7]
 * Output: 6
 * Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 *
 * Time Complexity: O()
 * Space Complexity: O()
 */
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int len = nums.length;
        int[] help = new int[100002];
        int minv = Integer.MAX_VALUE, maxv = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            help[nums[i]]++;
            minv = Math.min(minv, nums[i]);
            maxv = Math.max(maxv, nums[i]);
        }

        int res = 0;
        int cur = minv;
        while (cur <= maxv) {
            if (help[cur] > 1) {
                help[cur + 1] += help[cur] - 1;
                res += help[cur] - 1;
            }

            cur++;
        }

        int x = help[maxv + 1] - 1;
        res += x > 0 ? x * (x + 1) / 2 : 0;
        return res;
    }
}