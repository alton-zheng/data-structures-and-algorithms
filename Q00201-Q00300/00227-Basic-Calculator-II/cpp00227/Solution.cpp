// Runtime: 4 ms, faster than 99.74% of C++ online submissions for Basic Calculator II.
// Memory Usage: 8.8 MB, less than 27.27% of C++ online submissions for Basic Calculator II.
class Solution {
public:
    int calculate(string s) {

        vector<int> help;

        char flag = '+';
        int num = 0;

        for (int i = 0; i < s.size(); i++) {
            if (s[i] - '0' >= 0 && s[i] - '0' <= 9) {
                num = num * 10 + int(s[i] - '0');

                if (i != s.size() - 1) {
                    continue;
                }

            }

            if (s[i] != ' ' || i == s.size() - 1) {
                switch(flag) {
                    case '+':
                        help.push_back(num);
                        break;
                    case '-':
                        help.push_back(-num);
                        break;
                    case '*':
                        help.back() *= num;
                        break;
                    default:
                        help.back() /= num;
                }

                flag = s[i];
                num = 0;
            }
        }

        for (int item: help) {
            num += item;
        }

        return num;
    }
};