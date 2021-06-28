// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Excel Sheet Column Title.
// Memory Usage: 6 MB, less than 31.48% of C++ online submissions for Excel Sheet Column Title.
class Solution {
public:
    string convertToTitle(int columnNumber) {
        string res;

        while (columnNumber-- > 0) {
            res += columnNumber % 26 + 'A';
            columnNumber /= 26;
        }

        reverse(res.begin(), res.end());
        return res;
    }
};