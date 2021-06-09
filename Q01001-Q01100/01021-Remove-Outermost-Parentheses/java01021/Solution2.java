package java01021;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: alton
 * @Date: Created in 6/9/21 3:18 PM
 * @Description:
 *
 * 1021. Remove Outermost Parentheses
 *
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A+B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string s, consider its primitive decomposition: s = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 *
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 *
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 *
 * Input: s = "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 *
 * Note:
 *
 * s.length <= 10000
 * s[i] is "(" or ")"
 * s is a valid parentheses string
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n/2)
 * stack
 */
class Solution2 {
    public String removeOuterParentheses(String s) {

        Queue<Character> stack = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                if (!stack.isEmpty()) {
                    sb.append('(');
                }
                stack.add('(');
                continue;
            }

            if (s.charAt(i) == ')') {
                if (stack.size() != 1) {
                    sb.append(')');
                }
                stack.poll();
            }
        }

        return sb.toString();
    }
}
