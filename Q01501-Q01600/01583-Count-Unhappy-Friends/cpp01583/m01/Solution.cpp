// Runtime: 86 ms, faster than 46.47% of C++ online submissions for Count Unhappy Friends.
// Memory Usage: 25.7 MB, less than 61.76% of C++ online submissions for Count Unhappy Friends.
class Solution {
public:
    int unhappyFriends(int n, vector<vector<int>>& preferences, vector<vector<int>>& pairs) {

        vector<vector<int>> help(n, vector<int>(n));

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n - 1; j++) {
                help[i][preferences[i][j]] = j;
            }
        }

        vector<int> pair(n);

        for (vector<int> p: pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }

        int res = 0;

        for (int x = 0; x < n ; x++) {
            int y = pair[x];
            int prefer = help[x][y];

            for (int i = 0; i < prefer; i++) {
                int u = preferences[x][i];
                int v = pair[u];

                if (help[u][x] < help[u][v]) {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
};