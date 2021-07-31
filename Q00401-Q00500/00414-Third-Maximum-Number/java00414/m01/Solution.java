package java00414.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/31 10:32 上午
 * @Description:
 * 414. Third Maximum Number #257
 * Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int thirdMax(int[] nums) {

        int len  = nums.length;

        // 长度小于等于 2 时，取最大值即可
        if (len <= 2) {
            return Math.max(nums[0], nums[len - 1]);
        }

        long first, second, third;
        first = second = third = Long.MIN_VALUE;

        for (int i = 0; i < len; i++) {

            int cur = nums[i];

            // 由于第几大都是不能重复的，也就是说当前元素 cur 如果等于 first, second 时，忽略即可
            if (cur == first || cur == second) {
                // 忽略当前元素
                continue;
            }

            // 当前元素大于 first, 更新 first, second, third
            if (cur > first) {
                third = second;
                second = first;
                first = cur;
                continue;
            }

            // 当前元素大于 second, 更新 third, second 指针
            if (cur > second) {
                third = second;
                second = cur;
                continue;
            }

            // 大于 third 时，更新 third 指针
            if (cur > third) {
                third = cur;
            }
        }

        return third == Long.MIN_VALUE ? (int)first : (int)third;

    }
}
