// Runtime: 6 ms, faster than 71.43% of C++ online submissions for Check if Move is Legal.
// Memory Usage: 10.8 MB, less than 100.00% of C++ online submissions for Check if Move is Legal.
class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {

        // 判断每个方向是否存在以操作位置为起点的好线段
        auto check = [&](int dx, int dy) -> bool {
            int x = rMove + dx;
            int y = cMove + dy;

            int step = 1;  // 当前遍历的节点序号
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (step == 1) {
                    if (board[x][y] == '.' || board[x][y] == color) {
                        return false;
                    }
                } else {
                    // 好线段不应该存在空格子
                    if (board[x][y] == '.') {
                        return false;
                    }

                    if (board[x][y] == color) {
                        return true;
                    }
                }

                step++;
                x += dx;
                y += dy;
            }

            // 不存在符合要求的线段
            return false;
        };

        // 从 x 轴正方向开始逆时针枚举 8 个格子
        vector<int> dx = {1, 1, 0, -1, -1, -1, 0, 1};
        vector<int> dy = {0, 1, 1, 1, 0, -1, -1, -1};

        for(int k = 0; k < 8; k++) {
            if (check(dx[k], dy[k])) {
                return true;
            }
        }
        return false;
    }
};