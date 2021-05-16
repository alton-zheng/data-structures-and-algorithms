package java00868;

/**
 * @Author: alton
 * @Date: Created in 5/16/21 10:47 PM
 * @Description:
 * 868. Binary Gap
 * Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary representation of n. If there are no two adjacent 1's, return 0.
 *
 * Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 22
 * Output: 2
 * Explanation: 22 in binary is "10110".
 * The first adjacent pair of 1's is "10110" with a distance of 2.
 * The second adjacent pair of 1's is "10110" with a distance of 1.
 * The answer is the largest of these two distances, which is 2.
 * Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
 * Example 2:
 *
 * Input: n = 5
 * Output: 2
 * Explanation: 5 in binary is "101".
 * Example 3:
 *
 * Input: n = 6
 * Output: 1
 * Explanation: 6 in binary is "110".
 * Example 4:
 *
 * Input: n = 8
 * Output: 0
 * Explanation: 8 in binary is "1000".
 * There aren't any adjacent pairs of 1's in the binary representation of 8, so we return 0.
 * Example 5:
 *
 * Input: n = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= n <= 109
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */
class Solution {
    public int binaryGap(int N) {

        // 将N 二进制的前一个 1 的位置初始化为 -1
        // 结果值根据题意初始化 为 0
        int last = -1, res = 0;

        // 获取数字 N 的最高有效位
        int max = 0;
        int temp = N;
        while (temp > 0) {
            temp >>= 1;
            max++;
        }

        for (int i = 0; i < max; ++i) {

            // 判断二进制向右移动 i 位后，最小位是否为 1
            if (((N >> i) & 1) == 1) {

                // 更新最大间隔 res
                if (last >= 0) {
                    res = res >= i - last ? res : i - last;
                }

                // 更新二进制前 1 的位置
                last = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().binaryGap(22));
    }
}
