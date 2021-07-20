// Runtime: 40 ms, faster than 67.38% of C++ online submissions for Subrectangle Queries.
// Memory Usage: 18.7 MB, less than 54.48% of C++ online submissions for Subrectangle Queries.
class SubrectangleQueries {

private:
    vector<vector<int>> help;
    int row, col;
public:
    SubrectangleQueries(vector<vector<int>>& rectangle): help(rectangle) {
        row = help.size();
        col = help[0].size();
    }

    void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int r = row1; r < row && r <= row2; r++) {
            for (int c = col1; c < col && c <= col2; c++) {
                help[r][c] = newValue;
            }
        }
    }

    int getValue(int row, int col) {
        return help[row][col];
    }
};
