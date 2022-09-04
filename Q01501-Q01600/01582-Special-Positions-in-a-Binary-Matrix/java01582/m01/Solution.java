package java01582.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-04 17:12
 * @Update Date Time: 2022-09-04 17:12
 * @Updated-By: alton_z
 * @Update-Location:
 * 1582. Special Positions in a Binary Matrix
 *
 * 模拟，这很好理解， 特殊值满足 3 个条件：
 * 1. mat[i][j] = 1
 * 2. i 行所有值相加等于 1
 * 3. j 列所有值相加等于 1
 *
 */
class Solution {
    public int numSpecial(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[] rowHelp = new int[m], colHelp = new int[n];

        // 所有的二维值遍历一遍， row, col 相加
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowHelp[i] += mat[i][j];
                colHelp[j] += mat[i][j];

            }
        }


        // 第二次遍历，判断是否 3 个条件
        int res = 0;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if (mat[i][j] == 1 && rowHelp[i] == 1 && colHelp[j] == 1) {
                    // 符合的结果加 1
                    res++;
                }
            }
        }

        return res;
    }
}
