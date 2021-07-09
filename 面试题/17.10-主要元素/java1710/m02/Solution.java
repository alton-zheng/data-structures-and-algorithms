package java1710.m02;

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
 * Space Complexity : O(1)
 * 摩尔定律来解决
 */
class Solution {
    public int majorityElement(int[] nums) {

        int res = -1, flag = 0;

        // 根据摩尔定理，得出可能的结果值，此值在数组中出现的次数最多
        for (int num : nums) {
            if (flag == 0) {
                res = num;
            }
            flag += num == res ? 1 : -1;
        }

        // 接下来只要判断此数值出现的次数是否超过数组元素个数的一半
        flag = 0;
        for (int num: nums) {
            if (num == res) {
                flag++;
            }
        }

        return flag > nums.length / 2 ? res : -1;
    }
}
