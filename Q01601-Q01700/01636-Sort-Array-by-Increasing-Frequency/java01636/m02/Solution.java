package java01636.m02;


import java.util.Arrays;

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
 * Time complexity : O(3N*LogN) -> O(NlogN)
 * Space Complexity : O(200) -> O(1)
 */
class Solution {
    public int[] frequencySort(int[] nums) {

        // 题目中限制了 -100 <= nums[i] <= 100，所以可能取值范围是 [-100, 100]
        int[] help = new int[201];

        // 由于数组索引不能为负数，首先遍历数组将元素放入 help 索引范围 [1, 200] 中
        // 并且将每个元素出现的频次存入到数组中
        for (int item : nums){
            help[item + 100]++;
        }

        // 更新原数组：
        // 1 频次越高，更新值越大
        // 2 频次相同，原值越大，更新值越小
        // 以上两者规则刚好符合题意
        for (int i = 0; i < nums.length; i++){
            nums[i] = 10000 * help[nums[i] + 100] - nums[i] + 100;
        }

        // 将更新后的 nums 升序排序， 刚好将数组按符合题意的顺序进行排列
        Arrays.sort(nums);

        // 接下来恢复原值即可
        for (int i = 0; i < nums.length; i ++){
            nums[i] = 100 - nums[i] % 10000;
        }

        return nums;
    }

    public static void main(String[] args) {
        new Solution().frequencySort(new int[]{5,2,3,3,2,4,4,4});
    }
}
