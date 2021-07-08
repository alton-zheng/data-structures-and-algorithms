// Runtime: 4 ms, faster than 7.24% of C++ online submissions for Thousand Separator.
// Memory Usage: 6 MB, less than 41.08% of C++ online submissions for Thousand Separator.
class Solution {
public:
    string thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }

        int init = 0;
        string res;
        while (n != 0) {
            init++;
            int cur = n % 10;
            n /= 10;
            res += to_string(cur);
            if (init == 3 & n != 0) {
                res += '.';
                init = 0;
            }
        }

        reverse(res.begin(), res.end());
        return res;
    }
};