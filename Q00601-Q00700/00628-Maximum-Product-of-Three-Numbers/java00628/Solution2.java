package java00628;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 5/23/21 6:04 PM
 * @Description:
 * 628. Maximum Product of Three Numbers #36
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 *
 * Input: nums = [-1,-2,-3]
 * Output: -6
 *
 *
 * Constraints:
 *
 * 3 <= len <= 104
 * -1000 <= nums[i] <= 1000
 *
 * 暴力解法
 * Time Complexity: O(NLogN)
 * Space Complexity: O(LogN)
 */
class Solution2 {
    public int maximumProduct(int[] nums) {
        // 先排序
        Arrays.sort(nums);

        // 数组长度
        int len = nums.length;

        /**
         *  通过分析， 3 个值在什么场景下最大：
         *  1： 2 负数相乘得正 * 最大正数
         *  2： 3 个最大正数
         *  所有结论是： 取这两者最大值可以得到答案
         */

        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 3] * nums[len - 2] * nums[len - 1]);
    }
}
