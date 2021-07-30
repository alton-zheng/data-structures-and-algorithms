package java00171.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/30 9:19 上午
 * @Description:
 * 171. Excel Sheet Column Number
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
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
 * Input: columnTitle = "A"
 * Output: 1
 * Example 2:
 *
 * Input: columnTitle = "AB"
 * Output: 28
 * Example 3:
 *
 * Input: columnTitle = "ZY"
 * Output: 701
 * Example 4:
 *
 * Input: columnTitle = "FXSHRXW"
 * Output: 2147483647
 *
 *
 * Constraints:
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
 * Memory Usage: 38.8 MB, less than 76.20% of Java online submissions for Excel Sheet Column Number.
 *
 * Time Complexity: O(Len)
 * Space Complexity: O(1)
 *
 */
class Solution {
    public int titleToNumber(String columnTitle) {

        int res = 0;
        for (char c: columnTitle.toCharArray()) {
            res = res * 26 + c - 'A' + 1;
        }

        return res;
    }
}
