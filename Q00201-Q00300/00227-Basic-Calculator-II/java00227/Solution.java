package java00227;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: alton
 * @Date: Created in 6/4/21 3:38 PM
 * @Description:
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 *
 * Runtime: 5 ms, faster than 96.69% of Java online submissions for Basic Calculator II.
 * Memory Usage: 42.6 MB, less than 9.48% of Java online submissions for Basic Calculator II.
 *
 *
 */
class Solution {
    public int calculate(String s) {

        int sLen = s.length();
        char flag = '+';
        int num = 0;
        int res = 0;
        int i = -1;

        Deque<Integer> help = new LinkedList<>();


        for (char c :  s.toCharArray()) {

            i++;
            if (c - '0' <= 9 && c - '0' >= 0) {
                num = num * 10 + c - '0';
                if (i != sLen - 1) {
                    continue;
                }
            }

            if (c != ' ' || i == sLen - 1) {

                switch (flag) {
                    case '+' :
                        help.push(num);
                        break;
                    case '-':
                        help.push(-num);
                        break;
                    case '*':
                        help.push(help.pop() * num);
                        break;
                    case '/':
                        help.push(help.pop() / num);
                        break;
                    default:
                        break;
                }

                flag = c;
                num = 0;
            }
        }

        while (help.size() > 0) {
            res += help.pop();
        }

        return res;

    }
}