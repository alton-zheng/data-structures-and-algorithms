// Runtime: 4 ms, faster than 78.47% of C++ online submissions for Remove Outermost Parentheses.
// Memory Usage: 6.7 MB, less than 66.44% of C++ online submissions for Remove Outermost Parentheses.
class Solution {
public:
    string removeOuterParentheses(string s) {

        int flag = 0;
        string res;

        for (char c: s) {

            if (c == '(') {
                flag++;
                if (flag > 1) {
                    res += '(';
                }

            } else {
                if (flag > 1) {
                    res += ')';
                }
                flag--;
            }
        }

        return res;
    }
};