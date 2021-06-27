package java00909.m01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: alton
 * @Date: Created in 6/27/21 7:50 AM
 * @Description:
 *
 * 909. Snakes and Ladders #151
 *
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:
 *
 *
 * You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:
 *
 * You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
 * (This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
 * If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
 * A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].
 *
 * Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)
 *
 * Return the least number of moves required to reach square N*N.  If it is not possible, return -1.
 *
 * Example 1:
 *
 * Input: [
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * Output: 4
 * Explanation:
 * At the beginning, you start at square 1 [at row 5, column 0].
 * You decide to move to square 2, and must take the ladder to square 15.
 * You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
 * You then decide to move to square 14, and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
 * Note:
 *
 * 2 <= board.length = board[0].length <= 20
 * board[i][j] is between 1 and N*N or is equal to -1.
 * The board square with number 1 has no snake or ladder.
 * The board square with number N*N has no snake or ladder.
 *
 * Time Complexity : O(N^N)
 * Space Complexity ： O(N^N)
 *
 * Runtime: 4 ms, faster than 81.36% of Java online submissions for Snakes and Ladders.
 * Memory Usage: 39.1 MB, less than 58.51% of Java online submissions for Snakes and Ladders.
 *
 * bfs
 *
 */
class Solution {
    public int snakesAndLadders(int[][] board) {

        int l = board.length;

        // 记录当前所在方格，以及走了多少步
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        // 记录当前方格已经过，已经过的，直接 pass，不需要重新走
        boolean[] seam = new boolean[l * l + 1];
        seam[1] = true;

        while (!queue.isEmpty()) {

            int[] curSquare = queue.poll();

            // 每一局走 1 到 6 个方格
            for (int i = 1; i <= 6; i++) {
                int nextSquare = curSquare[0] + i;

                // 根据方格以及 board 长度找到下一坐标
                int[] nextPosition = nextPosition(nextSquare, l);

                // 当下一位置不越界，且属于蛇梯，则通过蛇梯到达下一方格数字对应的方格（通俗点说，这种情况可以完成二次跳）
                // e.g. board[nextPosition[0]][nextPosition[1]] = 35， 则将 nextSquare 置为 35
                if (nextPosition[0] != -1 &&board[nextPosition[0]][nextPosition[1]] != -1) {
                    nextSquare = board[nextPosition[0]][nextPosition[1]];
                }

                // 当下一方格刚好到达终点，则游戏结束
                if (nextSquare == l * l) {
                    return curSquare[1] + 1;
                }

                // 下一方格，未经过时，则将此方格以及走了多少步数放入到队列中
                if (!seam[nextSquare]) {
                    seam[nextSquare] = true;
                    queue.offer(new int[]{nextSquare, curSquare[1] + 1});
                }
            }
        }

        return -1;

    }

    private int[] nextPosition(int nextSquare, int l) {

        // 找到从下到上，从左到右的 row, col 值
        int row = (nextSquare - 1) / l, col = (nextSquare - 1) % l;

        // 由于蛇梯的规则，将 col 拨乱反正
        if (row % 2 == 1) {
            col = l - 1 - col;
        }

        // row 越界， 坐标更新为 「-1， -1」， 不越界，得到正常坐标值
        return row > l - 1 ? new int[]{-1, -1} : new int[]{l - 1 - row, col};

    }
}
