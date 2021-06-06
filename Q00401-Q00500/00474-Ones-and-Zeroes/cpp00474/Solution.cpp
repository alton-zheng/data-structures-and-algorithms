// Runtime: 196 ms, faster than 66.01% of C++ online submissions for Ones and Zeroes.
// Memory Usage: 10 MB, less than 56.13% of C++ online submissions for Ones and Zeroes.
class Solution {
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        int len = strs.size();
        vector<vector<int>> help(m + 1, vector<int>(n + 1));

        vector<int> zerosOnes(2);
        int zeroes = 0, ones = 0;
        for (int l = 0; l < len; l++) {
            zerosOnes = getZerosOnes(strs[l]);
            zeroes = zerosOnes[0];
            ones = zerosOnes[1];

            for (int z = m; z >= zeroes; z--) {
                for (int o = n; o >= ones; o--) {
                    help[z][o] = max(help[z][o], help[z - zeroes][o - ones] + 1);
                }
            }
        }

        return help[m][n];
    }

private:
    vector<int> getZerosOnes(const string& str) {
        vector<int> res(2);

        for (char c: str) {
            res[c - '0']++;
        }

        return res;
    }
};