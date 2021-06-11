package java00279;

/**
 * @Author: alton
 * @Date: Created in 6/11/21 8:23 AM
 * @Description:
 *279. Perfect Squares #96
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 *
 * Time Complexity: O(N * genN)
 * Space Complexity: O(N)
 * Runtime: 21 ms, faster than 90.70% of Java online submissions for Perfect Squares.
 * Memory Usage: 37.9 MB, less than 75.06% of Java online submissions for Perfect Squares.
 *
 */
class Solution2 {

    public int numSquares(int n) {

        int[] help = new int[n + 1];

        int min;
        for (int i = 1; i <= n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, help[i - j*j]);
            }

            help[i] = min + 1;
        }

        return help[n];

    }
}
