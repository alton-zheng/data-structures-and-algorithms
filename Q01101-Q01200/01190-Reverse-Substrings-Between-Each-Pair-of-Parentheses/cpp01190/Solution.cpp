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
public:
    string reverseParentheses(string s) {

        int sLen = s.size();
        vector<int> parentheses(sLen);
        stack<int> queue;

        for (int i = 0; i < sLen; i++) {
            if (s[i] == '(') {
                queue.push(i);
            } else if (s[i] == ')'){
                int j = queue.top();
                queue.pop();
                parentheses[i] = j;
                parentheses[j] = i;
            }
        }

        string res;

        int index = 0, step = 1;
        while (index < sLen) {
            if (s[index] == '(' || s[index] == ')') {
                index = parentheses[index];
                step = -step;
            } else {
                res.push_back(s[index]);
            }

            index += step;
        }

        return res;
    }
};