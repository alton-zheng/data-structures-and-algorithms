package java01190;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: alton
 * @Date: Created in 5/26/21 9:09 AM
 * @Description: 1190. Reverse Substrings Between Each Pair of Parentheses #44
 * 
 * You are given a string s that consists of lower case English letters and brackets.
 * 
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * 
 * Your result should not contain any brackets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 * 
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Explanation: The substring "love" is reversed first, then the whole string is reversed.
 * Example 3:
 * 
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 * Example 4:
 * 
 * Input: s = "a(bcdefghijkl(mno)p)q"
 * Output: "apmnolkjihgfedcbq"
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It's guaranteed that all parentheses are balanced.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 此方法为常用的处理括号相关问题的解题方案
 * stack
 * 还可以使用递归来处理，递归方法不在这里演示了。
 */
class Solution2 {
    public String reverseParentheses(String s) {

        Deque<String> stack = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a(b(c)(de)f)g";
        System.out.println(new Solution2().reverseParentheses(s));

    }
}
