// Runtime: 44 ms, faster than 94.50% of C++ online submissions for Image Smoother.
// Memory Usage: 21.8 MB, less than 28.27% of C++ online submissions for Image Smoother.
class Solution {
public:
 vector<vector<int>> imageSmoother(vector<vector<int>>& img) {
        int row = img.size(), col = img[0].size();
        vector<vector<int>> res(row, vector<int>(col));

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int count = 0;
                for (int r2 = r - 1; r2 <= r + 1; r2++) {
                    for (int c2 = c - 1; c2 <= c + 1; c2++) {
                        // Select the 9 elements and determine the boundaries
                        if (r2 >= 0 && r2 < row && c2 >= 0 && c2 < col) {
                            res[r][c] += img[r2][c2];
                            count++;
                        }
                    }
                }

                res[r][c] /= count;

            }
        }
        return res;
    }
};