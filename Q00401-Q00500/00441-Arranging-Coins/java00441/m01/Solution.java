package java00441.m01;

/**
 * @Author: alton
 * @Date: Created in 6/27/21 10:43 AM
 * @Description:
 *
 * 441. Arranging Coins #152
 *
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 * Example 1:
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *
 * Constraints:
 * 1 <= n <= 2^31 - 1
 *
 * Time Complexity ： O(logN)
 * Space Complexity : O(1)
 *
 * Runtime: 8 ms, faster than 21.77% of Java online submissions for Arranging Coins.
 * Memory Usage: 38.3 MB, less than 9.66% of Java online submissions for Arranging Coins.
 */
class Solution {
    public int arrangeCoins(int n) {
        int level = 0;
        int temp = 1;
        while (n >= temp) {
            n -= temp;
            temp++;
            level++;
        }

        return level;
    }
}
