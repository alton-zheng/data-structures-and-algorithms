// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Decode String.
// Memory Usage: 6.4 MB, less than 74.29% of C++ online submissions for Decode String.
class Solution {
public:
    string decodeString(string s) {
        int len = s.size();
        stack<string> stk;
        stack<int> numStk;

        string res = "";
        string help = "";

        for (int i = 0; i < len; i++) {
            char cur = s[i];
            if  (cur >= '0' && cur <= '9') {
                int num = cur - '0';
                while (i + 1 < len && s[i + 1] >= '0' && s[i + 1] <= '9') {
                    num = num * 10 + s[i + 1] - '0';
                    i++;
                }
                numStk.push(num);
                continue;
            }

            if (cur == '[') {
                stk.push(res);
                res = "";
                continue;
            }


            if (cur == ']') {
                int num = numStk.top();
                numStk.pop();
                help += stk.top();
                stk.pop();
                while (num-- > 0) {
                    help += res;
                }

                res = help;
                help = "";
                continue;
            }

            res += cur;
        }

        return res;
    }
};