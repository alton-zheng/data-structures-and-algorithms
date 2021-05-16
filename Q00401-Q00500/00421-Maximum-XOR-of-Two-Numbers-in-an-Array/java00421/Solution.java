package java00421;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 5/16/21 10:13 AM
 * @Description:
 * 421. Maximum XOR of Two Numbers in an Array
 * Medium
 *
 * 2086
 *
 * 216
 *
 * Add to List
 *
 * Share
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.
 *
 * Follow up: Could you do this in O(n) runtime?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 * Example 2:
 *
 * Input: nums = [0]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [2,4]
 * Output: 6
 * Example 4:
 *
 * Input: nums = [8,10,2]
 * Output: 10
 * Example 5:
 *
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * Output: 127
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 *
 * Time Complexity: O(nlogc)
 * Space Complexity: O(n)
 */
class Solution {

    public int findMaximumXOR(int[] nums) {

        // 找到有效最高位 HIGH_BIT， 不需要官方题解中 31 位那么多
        int HIGH_BIT = 0;
        int max = nums[0] - 1;

        for (int num: nums) {


            int temp = 0;
            int compare = num;
            while (compare > 0 && num > max) {
                compare /= 2;
                temp++;
            }

            HIGH_BIT = Math.max(HIGH_BIT, temp);

            if (num > max) {
                max = num;
            }

        }

        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<>();

            // 将所有的 pre^k(aj) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                seen.add(num >> k);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = x * 2 + 1;
            boolean found = false;

            // 不需要重复遍历一遍所有元素, 仅需要遍历不重复的即可
            Iterator<Integer> hashSet = seen.iterator();
            while (hashSet.hasNext()) {
                if (seen.contains(xNext ^ hashSet.next())) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {

                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(new Solution().findMaximumXOR(nums));

    }
}