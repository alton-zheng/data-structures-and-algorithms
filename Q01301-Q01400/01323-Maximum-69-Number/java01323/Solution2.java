package java01323;

/**
 * @Author: alton
 * @Date: Created in 6/5/21 8:44 PM
 * @Description:
 * 1323. Maximum 69 Number #79
 *
 * Given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 *
 *
 * Example 1:
 *
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * Example 2:
 *
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * Example 3:
 *
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 10^4
 * num's digits are 6 or 9.
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Runtime: 7 ms, faster than 18.80% of Java online submissions for Maximum 69 Number.
 * Memory Usage: 37.5 MB, less than 7.70% of Java online submissions for Maximum 69 Number.
 */
class Solution2 {
    public int maximum69Number (int num) {
        int help = 0;
        if (num >= 6666) {
            help = 9999 - num;
        } else if (num >= 666) {
            help = 999 - num;

        } else if (num >= 66) {
            help = 99 - num;

        } else {
            help = 9 - num;
        }

        if (help == 0) {
            return num;
        } else {
            int len = (help + "").length();

            return num + 3 * (int)Math.pow(10, len - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maximum69Number(9669));
    }
}
