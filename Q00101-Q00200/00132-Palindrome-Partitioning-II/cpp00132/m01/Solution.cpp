// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {
public:
    int minCut(string s) {
        int len = s.size();

        vector<vector<int>> help(len + 1, vector<int>(len + 1));

        for (int r = 1; r <= len; r++) {
            for (int l = r; l >= 1; l--) {
                if (l == r) {
                    help[l][r] = true;
                } else {
                    if (s[l - 1] == s[r - 1]) {
                        if (r - l == 1 || help[l + 1][r - 1]) {
                            help[l][r] = true;
                        }
                    }
                }
            }
        }

        vector<int> res(len + 1);

        for (int r = 1; r <= len; r++)  {
            if (help[1][r]) {
                res[r] = 0;
            } else {
                res[r] = r - 1;

                for (int l = 1; l <= r; l++) {
                    if (help[l][r]) {
                        res[r] = min(res[r], res[l - 1] + 1);
                    }
                }
            }
        }

        return res[len];
    }
};