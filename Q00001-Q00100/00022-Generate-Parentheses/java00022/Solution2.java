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
 * Time Complexity: O(2^2n*n)
 * Space Complexity: O(2n)
 */
class Solution2 {


    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        generateAllParenthesis(new char[n * 2], 0, res);
        return res;
    }

    private void generateAllParenthesis(char[] chars, int i, List<String> res) {

        if (i == chars.length) {
            if (isVaild(chars)) {
                res.add(new String(chars));
            }
        } else {
            chars[i] = '(';
            generateAllParenthesis(chars, i + 1, res);
            chars[i] = ')';
            generateAllParenthesis(chars, i + 1, res);
        }

    }

    private boolean isVaild(char[] chars) {
        int flag = 0;

        for (char c: chars) {
            if (c == '(') {
                flag++;
            } else {
                flag--;
            }

            if (flag < 0) {
                return false;
            }
        }

        return flag == 0;

    }
}
