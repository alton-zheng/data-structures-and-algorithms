// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Generate a String With Characters That Have Odd Counts.
// Memory Usage: 6.3 MB, less than 37.98% of C++ online submissions for Generate a String With Characters That Have Odd Counts.
class Solution {
public:
    string generateTheString(int n) {
        string res(n, 'o');
        if (n % 2 == 0) {
            res[0] = 'e';
        }

        return res;
    }
};
