package java01449;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 6/12/21 8:12 AM
 * @Description:
 *
 * Given an array of integers cost and an integer target. Return the maximum integer you can paint under the following rules:
 *
 * The cost of painting a digit (i+1) is given by cost[i] (0 indexed).
 * The total cost used must be equal to target.
 * Integer does not have digits 0.
 * Since the answer may be too large, return it as string.
 *
 * If there is no way to paint any integer given the condition, return "0".
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [4,3,2,5,6,7,2,5,5], target = 9
 * Output: "7772"
 * Explanation:  The cost to paint the digit '7' is 2, and the digit '2' is 3. Then cost("7772") = 2*3+ 3*1 = 9. You could also paint "977", but "7772" is the largest number.
 * Digit    cost
 *   1  ->   4
 *   2  ->   3
 *   3  ->   2
 *   4  ->   5
 *   5  ->   6
 *   6  ->   7
 *   7  ->   2
 *   8  ->   5
 *   9  ->   5
 * Example 2:
 *
 * Input: cost = [7,6,5,5,5,6,8,7,8], target = 12
 * Output: "85"
 * Explanation: The cost to paint the digit '8' is 7, and the digit '5' is 5. Then cost("85") = 7 + 5 = 12.
 * Example 3:
 *
 * Input: cost = [2,4,6,2,4,6,4,4,4], target = 5
 * Output: "0"
 * Explanation: It's not possible to paint any integer with total cost equal to target.
 * Example 4:
 *
 * Input: cost = [6,10,15,40,40,40,40,40,40], target = 47
 * Output: "32211"
 *
 *
 * Constraints:
 *
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 *
 * Time Complexity: O(costLen * target)
 * Space Complexity: O(costLen * target)
 * Runtime: 7 ms, faster than 77.03% of Java online submissions for Form Largest Integer With Digits That Add up to Target.
 * Memory Usage: 39 MB, less than 75.68% of Java online submissions for Form Largest Integer With Digits That Add up to Target.
 */
class Solution2 {
    public String largestNumber(int[] cost, int target) {

        int[][] help = new int[10][target + 1];
        int[][] from = new int[10][target + 1];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(help[i], Integer.MIN_VALUE);
        }

        help[0][0] = 0;

        for (int i = 0; i < 9; i++) {
            int c = cost[i];
            for (int j = 0; j <= target; j++) {

                if (j < c || help[i][j] > help[i + 1][j -c] + 1) {
                    help[i + 1][j] = help[i][j];
                    from[i + 1][j] = j;
                } else {
                    help[i + 1][j] = help[i + 1][j - c] + 1;
                    from[i + 1][j] = j - c;
                }
            }
        }

        if (help[9][target] < 0) {
            return "0";
        }

        int i = 9, j = target;
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            if (j == from[i][j]) {
                --i;
            } else {
                sb.append(i);
                j = from[i][j];
            }
        }

        return sb.toString();
    }
}
