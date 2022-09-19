package java01636.m01;


import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/26/21 3:01 PM
 * @Description:
 *
 * 1636. Sort Array by Increasing Frequency #150
 *
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * Example 2:
 *
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * Example 3:
 *
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * Time complexity : O()
 * Space Complexity : O()
 * 流处理
 */
class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> help = new HashMap<>();

        // 统计每个数值的频率
        Arrays.stream(nums).forEach(n -> help.put(n, help.getOrDefault(n, 0) + 1));

        // 自定义 sort
        return Arrays.stream(nums).boxed()
                .sorted((a,b) -> !help.get(a).equals(help.get(b)) ? help.get(a) - help.get(b) : b - a)
                .mapToInt(n -> n)
                .toArray();

    }
}
