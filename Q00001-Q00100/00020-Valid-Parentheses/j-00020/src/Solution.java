/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.

 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new ArrayStack<>();

        for( int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(s.charAt(i));
            } else {

                if (stack.empty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }

                if (c == ']' && topChar != '[') {
                    return false;
                }

                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        printBool((new Solution()).isValid("()"));
        printBool((new Solution()).isValid("()[]{}"));
        printBool((new Solution()).isValid("(]"));
        printBool((new Solution()).isValid("([)]"));
    }
}
