package java01886.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 6/25/21 8:31 PM
 * @Description:
 * 1886. Determine Whether Matrix Can Be Obtained By Rotation #147
 *
 * Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * Output: true
 * Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
 * Example 2:
 *
 *
 * Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * Output: false
 * Explanation: It is impossible to make mat equal to target by rotating mat.
 * Example 3:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * Output: true
 * Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 *
 *
 * Constraints:
 *
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] and target[i][j] are either 0 or 1.
 *
 * Time Complexity : O(N^2)
 * Space Complexity : O(1)
 *
 * Runtime: 1 ms, faster than 67.32% of Java online submissions for Determine Whether Matrix Can Be Obtained By Rotation.
 * Memory Usage: 38.4 MB, less than 66.64% of Java online submissions for Determine Whether Matrix Can Be Obtained By Rotation.
 */
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int len = mat.length;

        // 旋转 4 次,每旋转一次，比对一次
        for (int k = 0; k < 4; k++) {
            // 旋转操作
            for (int i = 0; i < len / 2; i++) {
                for (int j = 0; j < (len + 1) / 2; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[len-1-j][i];
                    mat[len-1-j][i] = mat[len-1-i][len-1-j];
                    mat[len-1-i][len-1-j] = mat[j][len-1-i];
                    mat[j][len-1-i] = temp;
                }
            }

            int flag = 0;
            for (int i = 0 ; i < len; i++) {
                if (Arrays.equals(mat[i], target[i])) {
                    flag++;
                }
            }

            if (flag == len) {
                return true;
            }

        }
        return false;
    }
}
