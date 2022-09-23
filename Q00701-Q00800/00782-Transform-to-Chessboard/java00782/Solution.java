package java00782;

import java.util.*;


/**
 * @Author: alton
 * @Date: Created in 5/17/21 8:31 PM
 * @Description: 782. Transform to Chessboard #15
 * An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.
 * <p>
 * What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 4-directionally adjacent? If the task is impossible, return -1.
 * <p>
 * Examples:
 * Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 * Output: 2
 * Explanation:
 * One potential sequence of moves is shown below, from left to right:
 * <p>
 * 0110     1010     1010
 * 0110 --> 1010 --> 0101
 * 1001     0101     1010
 * 1001     0101     0101
 * <p>
 * The first move swaps the first and second column.
 * The second move swaps the second and third row.
 * <p>
 * <p>
 * Input: board = [[0, 1], [1, 0]]
 * Output: 0
 * Explanation:
 * Also note that the board with 0 in the top left corner,
 * 01
 * 10
 * <p>
 * is also a valid chessboard.
 * <p>
 * Input: board = [[1, 0], [1, 0]]
 * Output: -1
 * Explanation:
 * No matter what sequence of moves you make, you cannot end with a valid chessboard.
 * Note:
 * <p>
 * board will have the same number of rows and columns, a number in the range [2, 30].
 * board[i][j] will be only 0s or 1s.
 * <p>
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 */
class Solution {
    public int movesToChessboard(int[][] board) {

        int bLength = board.length;

        Map<Integer, Integer> count = new HashMap<>();
        for (int[] row: board) {
            int code = 0;

            for (int x: row) {
                code = 2 * code + x;
            }
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k1 = analyzeCount(count, bLength);

        if (k1 == -1) {
            return -1;
        }

        count = new HashMap<>();
        for (int c = 0; c < bLength; ++c) {
            int code = 0;
            for (int r = 0; r < bLength; ++r) {
                code = 2 * code + board[r][c];
            }
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k2 = analyzeCount(count, bLength);
        return k2 >= 0 ? (k1 + k2) : -1;
    }

    public int analyzeCount(Map<Integer, Integer> count, int bLength) {

        // 排除非2种值的情况，详情看题解
        if (count.size() != 2) {
            return -1;
        }

        // 获取原始 2 个数值
        List<Integer> keys = new ArrayList<>(count.keySet());

        // 提取值
        int key1 = keys.get(0), key2 = keys.get(1);
        int key1N = count.get(key1), key2N = count.get(key2);

        // 排除2组数字数量非半的情况
        if (
                !(key1N == bLength / 2 && key2N == (bLength + 1)/2) &&
                        !(key1N == (bLength + 1) / 2 && key2N == bLength / 2)
        ) {
            return -1;
        }

        int oneNumber = (1 << bLength) - 1;

        // 排除二进制不相异的情况
        if ((key1 ^ key2) != oneNumber) {
            return -1;
        }

        // 获取 keys 中 1 的数量
        int one = Integer.bitCount(key1 & oneNumber);

        int res = Integer.MAX_VALUE;

        // key1 为 0 开头的数字
        if (bLength % 2 == 0 || one * 2 < bLength) {
            res = Math.min(res, Integer.bitCount(key1 ^ 0xAAAAAAAA & oneNumber) / 2);
        }

        // key2 为 1 开头的数字
        if (bLength % 2 == 0 || one * 2 > bLength) {
            res = Math.min(res, Integer.bitCount(key1 ^ 0x55555555 & oneNumber) / 2);
        }


        return res;


    }
}
