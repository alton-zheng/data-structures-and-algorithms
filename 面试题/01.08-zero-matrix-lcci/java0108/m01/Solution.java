package java0108.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-30 13:31
 * @Update Date Time: 2022-09-30 13:31
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
