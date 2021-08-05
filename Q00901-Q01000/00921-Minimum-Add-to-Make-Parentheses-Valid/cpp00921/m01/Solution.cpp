
// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Minimum Add to Make Parentheses Valid.
// Memory Usage: 6.1 MB, less than 82.61% of C++ online submissions for Minimum Add to Make Parentheses Valid.
class Solution {
public:
    int minAddToMakeValid(string s) {

        int res = 0;
        int left = 0;

        for (char c: s) {
            if (c == '(') {
                left++;
                continue;
            }

            if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
            }
        }

        res += left;
        return res;
    }
};