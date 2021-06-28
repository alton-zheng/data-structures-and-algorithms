package java00168.m02;

import java.util.Stack;

/**
 * @Author: alton
 * @Date: Created in 6/29/21 12:08 AM
 * @Description:
 *
 * 168. Excel Sheet Column Title #157
 *
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 *
 * Input: columnNumber = 1
 * Output: "A"
 * Example 2:
 *
 * Input: columnNumber = 28
 * Output: "AB"
 * Example 3:
 *
 * Input: columnNumber = 701
 * Output: "ZY"
 * Example 4:
 *
 * Input: columnNumber = 2147483647
 * Output: "FXSHRXW"
 *
 *
 * Constraints:
 *
 * 1 <= columnNumber <= 231 - 1
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
 * Memory Usage: 36.2 MB, less than 51.99% of Java online submissions for Excel Sheet Column Title.
 */
class Solution {
    public String convertToTitle(int columnNumber) {

        Stack<Character> stk = new Stack();

        while (columnNumber-- > 0) {
            stk.push((char)((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }

        StringBuilder res = new StringBuilder();

        while (!stk.isEmpty()) {
            res.append(stk.pop());
        }

        return res.toString();
    }
}
