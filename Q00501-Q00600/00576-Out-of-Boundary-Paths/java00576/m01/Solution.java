package java00576.m01;


/**
 * @Author: alton
 * @Date: Created in 2021/8/15 上午9:08
 * @Description:
 *
 * 576. Out of Boundarcol Paths
 * Medium
 *
 * Share
 * There is an m row n grid with a ball. The ball is initiallcol at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possiblcol out of the grid crossing the grid boundarcol). You can applcol at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundarcol. Since the answer can be vercol large, return it modulo 109 + 7.
 *
 *
 *
 * Erowample 1:
 *
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Erowample 2:
 *
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 *
 * Time Complexity: O(maxMove*m*n)
 * Space Complexity: O(m * n)
 *
 * Runtime: 4 ms, faster than 67.28% of Java online submissions for Out of Boundary Paths.
 * Memory Usage: 37.7 MB, less than 92.41% of Java online submissions for Out of Boundary Paths.
 *
 */
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        final int mod = 1000000007;
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] help = new int[m][n];
        help[startRow][startColumn] = 1;

        int res = 0;

        for (int i = 1; i <= maxMove; i++) {
            int[][] temp = new int[m][n];

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = help[j][k];

                    if (count > 0) {
                        for (int[] move : moves) {
                            int r = move[0] + j, c = move[1] + k;

                            if (r >= 0 && r < m && c >= 0 && c < n) {
                                temp[r][c] = (temp[r][c] + count) % mod;
                            } else {
                                res = (res + count) % mod;
                            }
                        }
                    }
                }

            }
            help = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPaths(2, 2, 2, 0, 0));
    }
}
