package java01074;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 5/29/21 8:37 AM
 * @Description:
 * 1074. Number of Submatrices That Sum to Target #53
 *
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 * Example 2:
 *
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 * Example 3:
 *
 * Input: matrix = [[904]], target = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 *
 * Time Complexity: O(m2*n*n^2)
 * Space Complexity: O(m*n)
 *
 * Runtime: 88 ms, faster than 91.06% of Java online submissions for Number of Submatrices That Sum to Target.
 * Memory Usage: 40.4 MB, less than 23.30% of Java online submissions for Number of Submatrices That Sum to Target.
 *
 */
class Solution2 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int res = 0;
        int outer = matrix.length, inner = matrix[0].length;

        // List the upper boundary with index i
        for (int upper = 0; upper < outer; upper++) {

            int[] subArr = new int[inner];

            // List the lower boundary with index j
            for (int lower = upper; lower < outer; lower++) {

                // Update the sum of elements for each col
                for (int col = 0; col < inner; col++) {
                    subArr[col] += matrix[lower][col];
                }

               res += getSubArrWithTarget(subArr, target);

            }
        }

        return res;
    }

    private int getSubArrWithTarget(int[] subArr, int target) {
        int count = 0;
        for (int start = 0; start < subArr.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += subArr[end];
                if (sum == target) {
                    count++;
                }
            }
        }

        return count;
    }
}


