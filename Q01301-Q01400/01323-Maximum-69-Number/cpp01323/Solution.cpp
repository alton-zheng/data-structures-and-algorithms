// Runtime: 4 ms, faster than 100.00% of C++ online submissions for Maximum 69 Number.
// Memory Usage: 5.9 MB, less than 40.36% of C++ online submissions for Maximum 69 Number.
class Solution {
public:
    int maximum69Number(int num) {
        string s = to_string(num);
        for (char& ch: s) {
            if (ch == '6') {
                ch = '9';
                break;
            }
        }
        return stoi(s);
    }
};