package java01337.m03;

import java.util.Arrays;

/**
 * Runtime: 1 ms, faster than 99.12% of Java online submissions for The K Weakest Rows in a Matrix.
 * Memory Usage: 39.6 MB, less than 93.74% of Java online submissions for The K Weakest Rows in a Matrix.
 */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;

        int[][] help = new int[m][2];

        for (int i  = 0; i < m; i++) {
            help[i] = new int[]{getOnes(mat[i]),i};
        }

        Arrays.sort(help, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = help[i][1];
        }

        return res;


    }

    private int getOnes(int[] arr) {

        int left = 0, right = arr.length;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;

            if (arr[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}