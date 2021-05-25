package java01787;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 5/25/21 2:34 PM
 * @Description:
 * 1787. Make the XOR of All Segments Equal to Zero #40
 * You are given an array nums​​​ and an integer k​​​​​. The XOR of a segment [left, right] where left <= right is the XOR of all the elements with indices between left and right, inclusive: nums[left] XOR nums[left+1] XOR ... XOR nums[right].
 *
 * Return the minimum number of elements to change in the array such that the XOR of all segments of size k​​​​​​ is equal to zero.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0,3,0], k = 1
 * Output: 3
 * Explanation: Modify the array from [1,2,0,3,0] to from [0,0,0,0,0].
 * Example 2:
 *
 * Input: nums = [3,4,5,2,1,7,3,4,7], k = 3
 * Output: 3
 * Explanation: Modify the array from [3,4,5,2,1,7,3,4,7] to [3,4,7,3,4,7,3,4,7].
 * Example 3:
 *
 * Input: nums = [1,2,4,1,2,5,1,2,6], k = 3
 * Output: 3
 * Explanation: Modify the array from [1,2,4,1,2,5,1,2,6] to [1,2,3,1,2,3,1,2,3].
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 2000
 * ​​​​​​0 <= nums[i] < 210
 *
 * Time Complexity: O()
 * Space Complexity: O()
 */
class Solution {

    // x 的范围为 [0, 2^10)
    static final int MAXX = 1 << 10;

    // 极大值，为了防止整数溢出选择 MAX / 2
    static final int INFTY = Integer.MAX_VALUE / 2;

    public int minChanges(int[] nums, int k) {

        int numsLen = nums.length;

        int[] f = new int[MAXX];

        Arrays.fill(f, INFTY);

        // 边界条件 f(-1,0)=0
        f[0] = 0;

        for (int i = 0; i < k; i++) {
            // 第 i 个组的哈希映射
            Map<Integer, Integer> cnt = new HashMap<>();
            int size = 0;
            for (int j = i; j < numsLen; j += k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                size++;
            }

            // 求出 t2
            int t2min = Arrays.stream(f).min().getAsInt();

            int[] g = new int[MAXX];
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < MAXX; mask++) {
                // t1 则需要枚举 x 才能求出
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey(), countx = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
                }
            }

            // 别忘了加上 size
            for (int j = 0; j < MAXX; ++j) {
                g[j] += size;
            }
            f = g;
        }

        return f[0];
    }
}
