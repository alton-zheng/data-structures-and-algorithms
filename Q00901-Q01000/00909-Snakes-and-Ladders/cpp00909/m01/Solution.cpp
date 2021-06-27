// Runtime: 20 ms, faster than 52.17% of C++ online submissions for Snakes and Ladders.
// Memory Usage: 12.4 MB, less than 83.21% of C++ online submissions for Snakes and Ladders.
// bfs
class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        int l = board.size();

        // 记录当前所在方格，以及走了多少步
        queue<pair<int, int>> q;
        q.emplace(1, 0);

        // 记录当前方格已经过，已经过的，直接 pass，不需要重新走
        vector<bool> seam(l * l + 1);
        seam[1] = true;

        while (!q.empty()) {

            pair<int,int> curSquare = q.front();
            q.pop();

            // 每一局走 1 到 6 个方格
            for (int i = 1; i <= 6; i++) {
                int nextSquare = curSquare.first + i;

                // 根据方格以及 board 长度找到下一坐标
                pair<int, int> nextPosition = next(nextSquare, l);

                // 当下一位置不越界，且属于蛇梯，则通过蛇梯到达下一方格数字对应的方格（通俗点说，这种情况可以完成二次跳）
                // e.g. board[nextPosition[0]][nextPosition[1]] = 35， 则将 nextSquare 置为 35
                if (nextPosition.first != -1 &&board[nextPosition.first][nextPosition.second] != -1) {
                    nextSquare = board[nextPosition.first][nextPosition.second];
                }

                // 当下一方格刚好到达终点，则游戏结束
                if (nextSquare == l * l) {
                    return curSquare.second + 1;
                }

                // 下一方格，未经过时，则将此方格以及走了多少步数放入到队列中
                if (!seam[nextSquare]) {
                    seam[nextSquare] = true;
                    q.emplace(nextSquare, curSquare.second + 1);
                }
            }
        }

        return -1;

    }

private:
   pair<int, int> next(int nextSquare, int l) {

        // 找到从下到上，从左到右的 row, col 值
        int row = (nextSquare - 1) / l, col = (nextSquare - 1) % l;

        // 由于蛇梯的规则，将 col 拨乱反正
        if (row % 2 == 1) {
            col = l - 1 - col;
        }

       // row 越界， 坐标更新为 「-1， -1」， 不越界，得到正常坐标值
       if (row > l - 1) {
           return {-1, -1};
       }

       return {l - 1 - row, col};


    }
};