package java0015.m02;

/**
 * @Author: alton
 * @Date: Created in 6/23/21 8:23 PM
 * @Description:
 *
 * 剑指 Offer 15. 二进制中1的个数
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 *
 * 提示：
 *
 * 输入必须是长度为 32 的 二进制串 。
 *
 * Time Complexity: O(1)
 * Space Complexity : O(1)
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            n &= n - 1;
            res++;
        }

        return res;
    }
}
