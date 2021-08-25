package java00169.m02;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/25 5:14 下午
 * @Description:
 *
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * Time Complexity: O(N)
 * Space Complexity:O(1)
 *
 * Runtime: 2 ms, faster than 58.15% of Java online submissions for Majority Element.
 * Memory Usage: 45 MB, less than 28.81% of Java online submissions for Majority Element.
 *
 */
class Solution {
    public int majorityElement(int[] nums) {

        int cnt = 0;
        Integer help = null;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                help = nums[i];
            }
            cnt += (nums[i] == help) ? 1 : -1;
        }

        return help;

    }
}
