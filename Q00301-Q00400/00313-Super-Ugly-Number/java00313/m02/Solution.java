package java00313.m02;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/9 12:21 下午
 * @Description:
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m + n)
 *
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int len = primes.length;
        int[] pointers = new int[len + 1];

        Arrays.fill(pointers, 1);

        for (int i = 2; i <= n; i++) {
            int[] nums = new int[len + 1];
            int minNum = Integer.MAX_VALUE;

            for (int j = 1; j <= len; j++) {
                nums[j] = dp[pointers[j]] * primes[j - 1];
                minNum = Math.min(minNum, nums[j]);
            }

            dp[i] = minNum;

            for (int j = 1; j <= len; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }

        return dp[n];
    }
}
