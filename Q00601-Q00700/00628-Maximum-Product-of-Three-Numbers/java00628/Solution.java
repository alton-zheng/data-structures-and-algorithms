package java00628;

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
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 *
 * 在不排序的情况下， 解题
 * 问题边界，和 排序是一致的。
 * 需要 5 个值
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

/**
 *  通过分析， 3 个值在什么场景下最大：
 *  1： 2 负数相乘得正 * 最大正数
 *  2： 3 个最大正数
 *  所有结论是： 取这两者最大值可以得到答案
 */
class Solution {
    public int maximumProduct(int[] nums) {

        // 先定义 5 个值
        // 1000 为 题目最大值， -1000 为最小值
        int min1 = 1001, min2 = 1001;
        int max1 = -1001, max2 = -1001, max3 = -1001;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return Math.max(min2 * min1 * max1, max3 * max2 * max1);

    }
}
