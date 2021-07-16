package java0053.m01;

/**
 * @Author: alton
 * @Date: Created in 7/16/21 8:24 AM
 * @Description:
 *
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 41.1 MB , 在所有 Java 提交中击败了 83.27% 的用户
 *
 * 时间复杂度：O(logN)
 * 空间复杂度： O(1)
 */
class Solution {
    public int search(int[] nums, int target) {

        int len = nums.length;
        int left = 0, right = len;
        int res = 0;

        if (len == 1 && nums[0] == target) {
            return 1;
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                res++;
                int pre = mid;
                while (--pre >= 0 && nums[pre] == target) {
                    res++;
                }

                pre = mid;
                while (++pre < len && nums[pre] == target) {
                    res++;
                }

                return res;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;
    }
}
