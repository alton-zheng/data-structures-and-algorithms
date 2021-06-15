// Runtime: 24 ms, faster than 95.36% of C++ online submissions for Kth Smallest Element in a Sorted Matrix.
// Memory Usage: 13.1 MB, less than 72.79% of C++ online submissions for Kth Smallest Element in a Sorted Matrix.
class Solution {

private:
    int kth = 0;
    int l = 0;

    bool judge(vector<vector<int>>& matrix, int mid) {

        int count = 0;
        int row = l - 1, col = 0;
        while (row >= 0 && col <= l - 1){

            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }

        }

        return count >= kth;
    }

public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        kth = k;
        l = matrix.size();
        int left = matrix[0][0], right = matrix[l - 1][l - 1], mid;

        while (left < right) {

            mid = left + (right - left) / 2;
            if (judge(matrix, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
};