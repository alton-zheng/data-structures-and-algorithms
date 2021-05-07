/**
 * 9. Palindrome Number
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 *
 * Input: x = -101
 * Output: false
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 * Time Complexity: O(n / 2)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isPalindrome(int x) {

        /**
         * 特殊情况：
         * 如上所述，当 x < 0 时，x 不是回文数。
         * 同样地，如果数字的最后一位是 0，为了使该数字为回文，
         * 则其第一位数字也应该是 0
         * 只有 0 满足这一属性
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        /**
         * 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
         * 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
         * 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
         */
        return x == revertedNumber || x == revertedNumber / 10;
    }
}