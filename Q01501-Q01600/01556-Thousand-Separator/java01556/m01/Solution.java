package java01556.m01;

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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Thousand Separator.
 * Memory Usage: 36.3 MB, less than 49.53% of Java online submissions for Thousand Separator.
 * string
 */
class Solution {
    public String thousandSeparator(int n) {

        String source = String.valueOf(n);
        int init = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = source.length() - 1; i >= 0; i--) {
            init++;
            sb.append(source.charAt(i));
            if (init == 3 && i != 0) {
                sb.append('.');
                init = 0;
            }
        }

        return sb.reverse().toString();
    }
}
