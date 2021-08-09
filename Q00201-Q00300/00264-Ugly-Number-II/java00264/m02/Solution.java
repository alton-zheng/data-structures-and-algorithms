package java00264.m02;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/9 3:46 下午
 * @Description:
 * Runtime: 2 ms, faster than 98.69% of Java online submissions for Ugly Number II.
 * Memory Usage: 38.3 MB, less than 51.44% of Java online submissions for Ugly Number II.
 */
class Solution {
    public int nthUglyNumber(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1, p3 = 1, p5 = 1;

        for (int i = 2; i <= n; i++) {

            int two = dp[p2] * 2, three = dp[p3] * 3, five = dp[p5] * 5;

            dp[i] = Math.min(Math.min(two, three), five);

            if (dp[i] == two) {
                p2++;
            }

            if (dp[i] == three) {
                p3++;
            }

            if (dp[i] == five) {
                p5++;
            }
        }

        return dp[n];
    }
}
