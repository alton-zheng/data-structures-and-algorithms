package java00378.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 6/15/21 1:40 PM
 * @Description:
 * 378. Kth Smallest Element in a Sorted Matrix #114
 *
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * Example 2:
 *
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 *
 *
 * Constraints:
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
 * 1 <= k <= n^2
 *
 * Time Complexity :O(N^2LogN)
 * Space Complexity :O(N^2)
 *
 * Runtime: 6 ms, faster than 70.46% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 * Memory Usage: 44.5 MB, less than 52.43% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int[] res = new int[matrix.length * matrix.length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               res[index++] = matrix[i][j];
            }
        }
        Arrays.sort(res);
        return res[k - 1];
    }
}
