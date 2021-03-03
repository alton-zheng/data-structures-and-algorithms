/// Source : https://leetcode.com/problems/valid-parentheses/description/
/// Author : liuyubobobo
/// Time   : 2017-11-17


// Using Stack
// Time Complexity: O(n)
// Space Complexity: O(n)
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
