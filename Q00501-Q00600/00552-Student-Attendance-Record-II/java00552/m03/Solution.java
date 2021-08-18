package java00552.m03;

/**
 * @Author: alton
 * @Date: Created in 2021/8/18 下午2:32
 * @Description:
 *
 * 552. Student Attendance Record II
 *
 * An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:
 *
 * 'A': Absent.
 * 'L': Late.
 * 'P': Present.
 * Any student is eligible for an attendance award if they meet both of the following criteria:
 *
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 8
 * Explanation: There are 8 records with length 2 that are eligible for an award:
 * "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
 * Example 2:
 *
 * Input: n = 1
 * Output: 3
 * Example 3:
 *
 * Input: n = 10101
 * Output: 183236316
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 *
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Student Attendance Record II.
 * Memory Usage: 36.1 MB, less than 90.23% of Java online submissions for Student Attendance Record II.
 *
 * 矩阵快速幂
 */
class Solution {
    int len = 6;
    int mod = (int)1e9+7;

    public int checkRecord(int n) {
        // help[0][0] = 1, 和 dp[0][0] 含义一致
        // 这里将 dp 二维，进行了降维处理
        long[][] help = new long[][]{{1}, {0}, {0}, {0}, {0}, {0}};

        // [0, 5] 状态转化， e.g. stat[0][0, 1, 2] -> 「0」,
        // 简单点说就是 [0, 1, 2] 可以转换为 「0」
        long[][] stat = new long[][]{
                {1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}
        };

        // n 不为 0， 处理
        // 快速幂
        while (n != 0) {

            if ((n & 1) != 0) {
                help = mul(stat, help);
            }

            stat = mul(stat, stat);

            // n >> 1 处理， 这里就决定了时间复杂度： O(logN)
            n >>= 1;

        }

        // 定义结果值
        int res = 0;

        // 将处于每种状态的值加到结果中
        for (int i = 0; i < len; i++) {
            res += help[i][0];
            res %= mod;
        }

        return res;

    }

    private long[][] mul(long[][] first, long[][] second) {
        int r = first.length, c = second[0].length, z = second.length;
        long[][] ans = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    ans[i][j] += first[i][k] * second[k][j];
                    ans[i][j] %= mod;
                }
            }
        }
        return ans;
    }
}
