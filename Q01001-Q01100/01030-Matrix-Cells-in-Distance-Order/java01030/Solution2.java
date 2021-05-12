package java01030;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 5/12/21 1:49 PM
 * @Description:
 * Time Complexity: O(RC)
 * Space Complexity: O(RC)
 *
 *
 */
class Solution2 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        // 最大距离
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);

        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }

        int[][] res = new int[R * C][];

        int index = 0;

        for (int i = 0; i <= maxDist; i++) {
            for (int[] it: bucket.get(i)) {
                res[index++] = it;
            }
        }

        return res;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
