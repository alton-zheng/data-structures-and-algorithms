package java01190;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public String reverseParentheses(String s) {

        // s 长度
        int sLen = s.length();

        // 双端 stack
        Deque<Integer> stack = new LinkedList<>();

        int[] parenthe = new int[sLen];

        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                parenthe[i] = j;
                parenthe[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        int index = 0, step = 1;

        while (index < sLen) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = parenthe[index];
                step = -step;
            }else {
                sb.append(s.charAt(index));
            }

            index += step;

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("(a(bc)de)"));
    }
}
