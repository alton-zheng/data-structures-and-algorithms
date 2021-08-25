package java00136.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/25 4:48 下午
 * @Description:
 * 136. Single Number #340
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *Runtime: 1 ms, faster than 93.99% of Java online submissions for Single Number.
 * Memory Usage: 38.7 MB, less than 95.35% of Java online submissions for Single Number.
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num: nums) {
            res ^= num;
        }

        return res;
    }
}
