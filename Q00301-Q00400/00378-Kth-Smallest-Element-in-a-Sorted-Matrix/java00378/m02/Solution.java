package java00378.m02;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 6/15/21 4:28 PM
 * @Description:
 *
 * Runtime: 15 ms, faster than 49.22% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 * Memory Usage: 45.2 MB, less than 19.10% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 *
 * Time Complexity : O(KlogN)
 * Space Complexity : O(N)
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int row = matrix.length;

        for (int i = 0; i < row; i++) {
            queue.offer(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] cur = queue.poll();
            if (cur[2] != row - 1) {
                queue.offer(new int[]{matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1});
            }
        }

        return Objects.requireNonNull(queue.poll())[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new int[][]{{1, 2, 3}, {4, 5, 8}, {6, 7, 9}}, 5));
    }
}
