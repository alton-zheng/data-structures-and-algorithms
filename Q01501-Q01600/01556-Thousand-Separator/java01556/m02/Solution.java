package java01556.m02;

import java.text.DecimalFormat;

/**
 * @Author: alton
 * @Date: Created in 7/8/21 8:15 PM
 * @Description:
 * 1556. Thousand Separator #186
 *
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 987
 * Output: "987"
 * Example 2:
 *
 * Input: n = 1234
 * Output: "1.234"
 * Example 3:
 *
 * Input: n = 123456789
 * Output: "123.456.789"
 * Example 4:
 *
 * Input: n = 0
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 0 <= n < 2^31
 *
 * Time Complexity : O(len(string(n)))
 * Space Complexity : O(N)
 * int
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Thousand Separator.
 * Memory Usage: 36.4 MB, less than 41.31% of Java online submissions for Thousand Separator.
 */
class Solution {
    public String thousandSeparator(int n) {

        if (n == 0) {
            return "0";
        }

        int init = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            init++;
            int cur = n % 10;
            n /= 10;
            sb.append(cur);
            if (init == 3 & n != 0) {
                sb.append('.');
                init = 0;
            }
        }

        return sb.reverse().toString();
    }

}