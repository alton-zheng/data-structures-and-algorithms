package java00552.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/18 上午8:50
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
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    public int checkRecord(int n) {

        final int mod = 1000000007;

        int[][][] help = new int[n + 1][2][3];
        help[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {

            // 考勤为 A 时, 缺勤
            // A + 1， L 为 0
            for (int k = 0; k <= 2; k++) {
                help[i][1][0] = (help[i][1][0] + help[i - 1][0][k]) % mod;
            }

            // 考勤为 L 时，迟到
            // 迟到 + 1， A 不变
            for (int a = 0; a <= 1; a++) {
                for(int l = 1; l <= 2; l++) {
                    help[i][a][l] = (help[i][a][l] + help[i - 1][a][l - 1]) % mod;
                }
            }

            // 考勤为 P 时， A 不变， L 为 0
            for (int a = 0; a <= 1; a++) {
                for (int l = 0; l <= 2; l++) {
                    help[i][a][0] = (help[i][a][0] + help[i - 1][a][l]) % mod;
                }
            }


        }

        int res = 0;

        for (int a = 0; a <= 1; a++) {
            for (int l = 0; l <= 2; l++) {
                res = (res + help[n][a][l]) % mod;
            }
        }

        return res;
    }
}
