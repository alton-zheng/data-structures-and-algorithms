package java01399.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 7/3/21 5:56 PM
 * @Description:
 * 1399. Count Largest Group #172
 *
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 *
 * Return how many groups have the largest size.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 * Example 2:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 * Example 3:
 *
 * Input: n = 15
 * Output: 6
 * Example 4:
 *
 * Input: n = 24
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 *
 * Time Complexity ： O(N*logN)
 * Space Complexity : O(1)
 * Runtime: 3 ms, faster than 96.48% of Java online submissions for Count Largest Group.
 * Memory Usage: 35.6 MB, less than 87.22% of Java online submissions for Count Largest Group.
 */
class Solution {
    public int countLargestGroup(int n) {

        int max = 0;
        if (n < 19) {
            max = 9;
        } else if (n < 199) {
            max = 18;
        } else if (n < 1999){
            max = 27;
        } else if (n <= 10000) {
            max = 36;
        }
        int[] help = new int[max + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 10] + i % 10;
            help[dp[i]]++;
        }

        Arrays.sort(help);

        int res = 0;
        int len = help[help.length - 1];
        for (int i = max; i >= 0; i--) {
            if (help[i] != len) {
                break;
            }
            res++;
        }

        return res;
    }
}
