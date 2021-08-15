// Runtime: 56 ms, faster than 9.17% of C++ online submissions for Out of Boundary Paths.
// Memory Usage: 19.6 MB, less than 7.85% of C++ online submissions for Out of Boundary Paths.

// 这种方法的性能比 cpp m01 差很多，请细品！
class Solution {

public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        vector<vector<int>> moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int mod = 1000000007;
        int res = 0;
        vector<vector<int>> help(m, vector<int>(n));
        help[startRow][startColumn] = 1;

        for (int i = 1; i <= maxMove; i++) {
            vector<vector<int>> temp(m, vector<int>(n));
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = help[j][k];
                    if (count > 0) {
                        for (vector<int> move: moves) {
                            int r = j + move[0], c = k + move[1];

                            if (r >= 0 && r < m && c >= 0 && c < n) {
                                temp[r][c] = (temp[r][c] + count) % mod;
                            } else {
                                res = (res + count) % mod;
                            }
                        }
                    }
                }
            }

            help = temp;
        }

        return res;

    }

};