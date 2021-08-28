package java00594.m01;

import java.util.HashMap;

/**
 * @Author: alton
 * @Date: Created in 2021/8/28 10:22 上午
 * @Description: 594. Longest Harmonious Subsequence #350
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0)  + 1);

            if (map.containsKey(num + 1)) {
                res = Math.max(res, map.get(num) + map.get(num + 1));
            }

            if (map.containsKey(num - 1)) {
                res = Math.max(res, map.get(num) + map.get(num  - 1));
            }
        }

        return res;

    }
}
