// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Replace All Digits with Characters.
// pMemory Usage: 6.2 MB, less than 20.85% of C++ online submissions for Replace All Digits with Characters.
class Solution {
public:
    string replaceDigits(string s) {
        int len = s.size();

        for (int i = 1; i < len; i += 2) {
            s[i] = s[i] - '0' + s[i - 1];
        }

        return s;
    }
};