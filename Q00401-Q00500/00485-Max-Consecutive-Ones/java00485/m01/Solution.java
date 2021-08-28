package java00485.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/28 11:00 上午
 * @Description:
 *
 *
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 *
 * 提示：
 *
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
Runtime: 3 ms, faster than 13.52% of Java online submissions for Max Consecutive Ones.
Memory Usage: 53.3 MB, less than 8.31% of Java online submissions for Max Consecutive Ones.
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int res = 0;

        for (int num: nums) {
            if (num == 1) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }

        res = Math.max(res, cnt);

        return res;
    }
}
