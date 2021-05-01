/**
 * 137. Single Number II
 * Medium
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 * <p>
 * <p>
 * Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

class Solution1 {

    /**
     * 方法一：哈希表
     * 思路与算法
     * 我们可以使用 hash map 统计数组中每个元素的出现次数。对于 hash map 中的每个 key-value 对，key 表示一个元素，value 表示其出现的次数。
     * 在统计完成后，我们遍历 hash map 即可找出只出现一次的元素。
     *
     * 复杂度分析:
     * 时间复杂度：$O(n)$，其中 `n` 是数组的长度。
     * 空间复杂度：$O(n)$。哈希映射中包含最多 `[n/3] + 1` 个元素，即需要的空间为  $O(n)$。
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

}