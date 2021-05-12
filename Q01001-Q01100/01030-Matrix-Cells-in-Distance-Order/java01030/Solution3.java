package java01030;

/**
 * @Author: alton
 * @Date: Created in 5/12/21 2:31 PM
 * @Description:
 * Time Complexity: O()
 * Space Complexity: O(1)
 */
class Solution3 {

    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);

        int[][] res = new int[R * C][];
        int row = r0, col = c0;

        int index = 0;
        res[index++] = new int[]{row, col};

        for (int dist = 1; dist <= maxDist; dist++) {
            row--;

            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if ( row >= 0 && row < R && col >= 0 && col < C) {
                        res[index++] = new int[]{row, col};
                    }

                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Solution3().allCellsDistOrder(3, 3, 1, 1));

    }
}
