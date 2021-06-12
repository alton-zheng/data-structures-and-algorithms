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
 * Space Complexity: O(target)
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Form Largest Integer With Digits That Add up to Target.
 * Memory Usage: 36.9 MB, less than 90.54% of Java online submissions for Form Largest Integer With Digits That Add up to Target.
 */
class Solution {
    public String largestNumber(int[] cost, int target) {

        int[] help = new int[target + 1];
        Arrays.fill(help, Integer.MIN_VALUE);
        help[0] = 0;

        for (int c: cost) {
            for (int j = c; j <= target; j++) {
                help[j] = Math.max(help[j], help[j - c] + 1);
            }
        }

        if (help[target] < 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9, j = target; i >= 1; i--) {
            for (int c = cost[i - 1]; j >= c && help[j] == help[j - c] + 1; j -= c) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
