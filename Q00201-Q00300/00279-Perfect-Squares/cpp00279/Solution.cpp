// Runtime: 108 ms, faster than 65.94% of C++ online submissions for Perfect Squares.
// Memory Usage: 9.1 MB, less than 36.02% of C++ online submissions for Perfect Squares.
class Solution {
public:
    int numSquares(int n) {

        vector<int> help(n + 1);

        int m;
        for (int i = 1; i <= n; i++) {
            m = INT_MAX;
            for (int j = 1; j * j <= i; j++) {
                m = min(m, help[i - j*j]);
            }

            help[i] = m + 1;
        }

        return help[n];
    }
};