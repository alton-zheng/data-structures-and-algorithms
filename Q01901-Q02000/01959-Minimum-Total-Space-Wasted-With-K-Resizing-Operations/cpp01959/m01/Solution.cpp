// Runtime: 432 ms, faster than 31.66% of C++ online submissions for Minimum Total Space Wasted With K Resizing Operations.
// Memory Usage: 13.9 MB, less than 20.49% of C++ online submissions for Minimum Total Space Wasted With K Resizing Operations.
class Solution {
public:
    int minSpaceWastedKResizing(vector<int>& nums, int k) {

        int len = nums.size();
        vector<vector<int>> help(len, vector<int>(len));

        for (int i = 0; i < len; i++) {

            int m = INT_MIN;
            int sum = 0;

            for (int j = i; j < len; j++) {

                int cur = nums[j];
                m = max(m, cur);
                sum += cur;
                help[i][j] = m * (j - i + 1) - sum;
            }
        }

        vector<vector<int>> res(len, vector<int>(k + 2, INT_MAX >> 1));

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < k + 2; j++) {
                for (int i0 = 0; i0 <= i; i0++) {
                    res[i][j] = min(res[i][j], (i0 == 0 ? 0 : res[i0 - 1][j - 1]) + help[i0][i]);
                }
            }
        }

        return res[len - 1][k + 1];
    }
};