package java00289;

/**
 * @Author: alton
 * @Date: Created in 5/28/21 12:37 PM
 * @Description:
 * 289. Game of Life #51
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 *
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 *
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 *
 * Time Complexity: O(m*n)
 * Space Complexity： O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
 * Memory Usage: 37.1 MB, less than 75.72% of Java online submissions for Game of Life.
 */
class Solution2 {
    public void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[][] dest = new int[rows][cols];

        // 复制二维数组
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dest[row][col] = board[row][col];
            }
        }

        int[] arr = {0, 1, -1};

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

    private int getOnes(int[][] dest, int[] arr, int row, int col) {

        int res = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(arr[i] == 0 && arr[j] == 0)) {
                    int r = row + arr[i];
                    int c = col + arr[j];

                    if (r < dest.length && r >= 0 && c < dest[0].length && c >= 0 && Math.abs(dest[r][c]) == 1) {
                        res++;
                    }
                }
            }
        }

        return res;

    }
}


