package java00202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: alton
 * @Date: Created in 5/29/21 11:34 AM
 * @Description:
 * 202. Happy Number #55
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 *
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * Runtime: 1 ms, faster than 79.35% of Java online submissions for Happy Number.
 * Memory Usage: 35.8 MB, less than 80.05% of Java online submissions for Happy Number.
 * exclusive cycleHelp
 */
class Solution {

    private static Set<Integer> cycleHelp =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public boolean isHappy(int n) {

        while (n != 1 && !cycleHelp.contains(n)) {
            n = nextNumber(n);
        }

        return n == 1;
    }

    private int nextNumber(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }

        return totalSum;
    }
}