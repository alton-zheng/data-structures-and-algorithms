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

class Solution {

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

    /**
     * 方法二：依次确定每一个二进制位
     * 思路与算法
     *
     * 为了方便叙述，我们称「只出现了一次的元素」为「答案」。
     *
     * 由于数组中的元素都在 \texttt{int}int（即 3232 位整数）范围内，因此我们可以依次计算答案的每一个二进制位是 00 还是 11。
     *
     * 具体地，考虑答案的第 ii 个二进制位（ii 从 00 开始编号），它可能为 00 或 11。对于数组中非答案的元素，每一个元素都出现了 33 次，对应着第 ii 个二进制位的 33 个 00 或 33 个 11，无论是哪一种情况，它们的和都是 33 的倍数（即和为 00 或 33）。因此：
     *
     * 答案的第 ii 个二进制位就是数组中所有元素的第 ii 个二进制位之和除以 33 的余数。
     *
     * 这样一来，对于数组中的每一个元素 xx，我们使用位运算 \texttt{(x >> i) \& 1}(x >> i) & 1 得到 xx 的第 ii 个二进制位，并将它们相加再对 33 取余，得到的结果一定为 00 或 11，即为答案的第 ii 个二进制位。
     *
     * 细节
     *
     * 需要注意的是，如果使用的语言对「有符号整数类型」和「无符号整数类型」没有区分，那么可能会得到错误的答案。这是因为「有符号整数类型」（即 \texttt{int}int 类型）的第 3131 个二进制位（即最高位）是补码意义下的符号位，对应着 -2^{31}−2
     * 31
     *  ，而「无符号整数类型」由于没有符号，第 3131 个二进制位对应着 2^{31}2
     * 31
     *  。因此在某些语言（例如 \texttt{Python}Python）中需要对最高位进行特殊判断。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetc-23t6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

    }


}