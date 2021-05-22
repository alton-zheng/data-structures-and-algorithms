package java00022;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 5/22/21 11:08 AM
 * @Description: 22. Generate Parentheses #32
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 * <p>
 * Time Complexity: O(4^n/genN)
 * Space Complexity: O(n)
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    private void generate(StringBuilder strs, int left, int right, int max, List<String> res) {

        if (strs.length() == 2 * max) {
            res.add(strs.toString());
            return;
        }

        if (left < max) {
            strs.append('(');
            generate(strs, left + 1, right, max, res);
            strs.deleteCharAt(strs.length() - 1);
        }

        if (left > right) {
            strs.append(')');
            generate(strs, left, right + 1, max, res);
            strs.deleteCharAt(strs.length() - 1);
        }

    }
}
