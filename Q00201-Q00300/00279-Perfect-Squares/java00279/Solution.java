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
 * Time Complexity: O(genN)
 * Space Complexity: O(1)
 *
 * Runtime: 2 ms, faster than 97.72% of Java online submissions for Perfect Squares.
 * Memory Usage: 38 MB, less than 68.13% of Java online submissions for Perfect Squares.
 *
 */
class Solution {
    private int source;
    public int numSquares(int n) {

        if (isfourSquareTheorem(n)) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }

        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)){
                return 2;
            }
        }

        return 3;

    }

    private boolean isfourSquareTheorem(int number) {

        while (number % 4 == 0) {
            number /= 4;
        }

        return number % 8 == 7;

    }

    private boolean isSquare(int number) {
        int sqrt = (int)Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}
