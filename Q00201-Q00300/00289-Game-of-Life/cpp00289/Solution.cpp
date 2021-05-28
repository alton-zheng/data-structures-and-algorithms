/**
 * Runtime: 4 ms, faster than 14.17% of C++ online submissions for Game of Life.
   Memory Usage: 7.1 MB, less than 15.59% of C++ online submissions for Game of Life.
 */
class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int rows = board.size();
        int cols = board[0].size();

        vector<vector<int>> dest(rows, vector<int>(cols));

        // 复制二维数组
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dest[row][col] = board[row][col];
            }
        }

        vector<int> arr = {0, 1, -1};

        for (int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // 获取 alive 的个数
                int ones = getOnes(dest, arr, row, col);

                if (dest[row][col] == 1 && (ones < 2  || ones > 3)) {
                    board[row][col] = -1;
                }

                if (dest[row][col] == 0 && ones == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }


    }

private:
 int getOnes(vector<vector<int>>& dest, vector<int>& arr, int row, int col) {

        int res = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(arr[i] == 0 && arr[j] == 0)) {
                    int r = row + arr[i];
                    int c = col + arr[j];

                    if (r < dest.size() && r >= 0 && c < dest[0].size() && c >= 0 && abs(dest[r][c]) == 1) {
                        res++;
                    }
                }
            }
        }

        return res;

    }
};