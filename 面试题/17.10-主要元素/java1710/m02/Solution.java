package java1710.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 7/9/21 8:33 AM
 * @Description:
 *
 * 面试题 17.10. 主要元素
 *
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * 下面解法中规中矩，性能优势不明显
 */
class Solution {
    public int majorityElement(int[] nums) {

        int len = nums.length;

        Map<Integer, Integer> help = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            help.put(cur, help.getOrDefault(cur, 0) + 1);

            if (help.get(cur) > len/2) {
                return cur;
            }
        }

        return -1;
    }
}
