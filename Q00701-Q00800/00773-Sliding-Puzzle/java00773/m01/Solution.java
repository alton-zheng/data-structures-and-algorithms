package java00773.m01;

import java.nio.charset.CharsetEncoder;
import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/26/21 9:56 AM
 * @Description:
 * 773. Sliding Puzzle #148
 *
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 *
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 *
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 *
 * Time Complexity : O((mn)!mn)
 * Space Complexity : O((mn)!mn)
 * Runtime: 4 ms, faster than 99.24% of Java online submissions for Sliding Puzzle.
 * Memory Usage: 38.5 MB, less than 64.10% of Java online submissions for Sliding Puzzle.
 *
 * bfs
 *
 */
class Solution {
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {

        // 定义目标值
        String target = "123450";

        StringBuffer sb = new StringBuffer();

        int outer = board.length;
        int inner = board[0].length;
        for (int i = 0; i < outer; i++) {
            for (int j = 0; j < inner; j++) {
                sb.append(board[i][j]);
            }
        }

        String initial = sb.toString();

        // 当目标值与初始值相等时， 说明不需要移动，步数为 0
        if (target.equals(initial)) {
            return 0;
        }

        // 定义结果值， 即步数
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        Set<String> seam = new HashSet<>();
        seam.add(initial);

        while (!queue.isEmpty()) {
            res++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                for (String nextStatus : next(cur)) {
                    if (!seam.contains(nextStatus)) {
                        if (target.equals(nextStatus)) {
                            return res;
                        }

                        queue.offer(nextStatus);
                        seam.add(nextStatus);
                    }
                }

            }
        }

        return -1;

    }

    private List<String> next (String cur) {
        List<String> ret = new ArrayList<>();
        int idx = cur.indexOf('0');
        char[] arr = cur.toCharArray();

        for (int i : neighbors[idx]) {
            swap(arr, idx, i);
            ret.add(new String(arr));
            swap(arr, idx, i);
        }

        return ret;
    }

    private void swap(char[] temp, int idx, int i) {
        char swap = temp[idx];
        temp[idx] = temp[i];
        temp[i] = swap;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }
}
