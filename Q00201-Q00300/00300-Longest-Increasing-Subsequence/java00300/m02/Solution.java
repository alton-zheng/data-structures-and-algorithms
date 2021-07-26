package java00300.m02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 2021/7/26 8:10 下午
 * @Description:
 * 300. Longest Increasing Subsequence #242
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * 利用贪心和二分搜索
 */
class Solution {
    public int lengthOfLIS(int[] nums) {

        // 定义 len , nums 的长度
        int len = nums.length;

        // 定义结果集
        List<Integer> res = new ArrayList<>();

        // 开始遍历数组
        for(int num: nums) {

            // 获取当前结果集大小
            int s = res.size();

            // 定义 left, right 边界
            int left = 0, right = s - 1;

            // 当结果集为空或者结果集最大值小于数组当前值时，不进入搜索，直接将 left 赋值为 s 的尺寸值，加快查询
            if (s == 0 || res.get(s - 1) < num) {
                left = s;
                right = -1;
            }

            // left 小于 right 时，进入二分搜索
            while (left < right) {

                // 找到 mid 值
                int mid = left + ((right - left) >> 1);

                // 当 结果集 mid 值小于数据当前值时，到右半部分找
                if (res.get(mid) < num) {
                    left = mid + 1;
                } else {
                    // 反之，左半部分找
                    right = mid;
                }
            }

            // left 等于 结果集大小时，说明当前结果集最大值小于当前数组值，直接添加到结果集即可
            if (left == res.size()) {
                // 新增
                res.add(num);
            } else {
                // 修改
                res.set(left, num);
            }

        }

        // 返回结果集大小
        return res.size();
    }
}
