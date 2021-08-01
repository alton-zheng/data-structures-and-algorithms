class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {

        int m = mat.size(), n = mat[0].size();

        vector<pair<int, int>> help(m);

        for (int r = 0; r < m; r++) {

            int cnt = 0;
            for (int c = 0; c < n; c++){
                if (mat[r][c] == 1) {
                    cnt++;
                } else {
                    break;
                }
            }

            help[r] = {cnt, r};
        }

        sort(help.begin(), help.end());

        vector<int> res(k);
        for (int i = 0; i < k; i++) {
            res[i] = help[i].second;
        }

        return res;

    }
};