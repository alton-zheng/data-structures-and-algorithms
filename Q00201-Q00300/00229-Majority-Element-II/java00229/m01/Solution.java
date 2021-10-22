package java00229.m01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Alton
 * @Date: 2021/10/22 8:40 上午
 * @Description:
 *
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
class Solution {

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> c: cnt.entrySet()) {
            if (c.getValue() > len / 3) {
                ans.add(c.getKey());
            }
        }

        return ans;
    }
}
