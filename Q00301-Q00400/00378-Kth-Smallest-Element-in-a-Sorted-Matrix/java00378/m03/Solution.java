package java00378.m03;

/**
 * @Author: alton
 * @Date: Created in 6/15/21 5:37 PM
 * @Description:
 *
 * Time Complexity : O(N*log(r - l))
 * Space Complexity : O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 * Memory Usage: 44.4 MB, less than 58.38% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len - 1][len - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (judge(matrix, mid, k, len)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean judge(int[][] matrix, int mid, int k, int len) {
        int i = len - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < len) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
