// Runtime: 28 ms, faster than 83.72% of C++ online submissions for Kth Smallest Element in a Sorted Matrix.
// Memory Usage: 13.6 MB, less than 54.36% of C++ online submissions for Kth Smallest Element in a Sorted Matrix.
class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {

        vector<int> res(matrix.size() * matrix[0].size());
        int idx = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                res[idx++] = matrix[i][j];
            }
        }

        sort(res.begin(), res.end());

        return res[k - 1];
    }
};