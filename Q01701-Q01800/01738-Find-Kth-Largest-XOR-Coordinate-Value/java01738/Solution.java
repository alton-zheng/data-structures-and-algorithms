package java01738;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 5/19/21 8:40 AM
 * @Description:
 * 1738. Find Kth Largest XOR Coordinate Value #19
 * You are given a 2D matrix of size m x n, consisting of non-negative integers. You are also given an integer k.
 *
 * The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j] where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).
 *
 * Find the kth largest value (1-indexed) of all the coordinates of matrix.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[5,2],[1,6]], k = 1
 * Output: 7
 * Explanation: The value of coordinate (0,1) is 5 XOR 2 = 7, which is the largest value.
 * Example 2:
 *
 * Input: matrix = [[5,2],[1,6]], k = 2
 * Output: 5
 * Explanation: The value of coordinate (0,0) is 5 = 5, which is the 2nd largest value.
 * Example 3:
 *
 * Input: matrix = [[5,2],[1,6]], k = 3
 * Output: 4
 * Explanation: The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd largest value.
 * Example 4:
 *
 * Input: matrix = [[5,2],[1,6]], k = 4
 * Output: 0
 * Explanation: The value of coordinate (1,1) is 5 XOR 2 XOR 1 XOR 6 = 0, which is the 4th largest value.
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 *
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 */
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {

        int rLen = matrix.length, cLen = matrix[0].length;

        int[] res = new int[rLen * cLen];
        int resIndex = 0;
        int[][] help = new int[rLen + 1][cLen + 1];

        for (int i = 1; i <= rLen; i++) {
            for (int j = 1; j <= cLen; j++) {
                help[i][j] = help[i - 1][j] ^ help[i - 1][j - 1] ^ help[i][j - 1] ^ matrix[i - 1][j - 1];
                res[resIndex++] = help[i][j];
            }
        }

        return getKthLargestValue(res, 0, rLen * cLen - 1, k - 1);

    }

    private int getKthLargestValue(int[] res, int startIndex, int endIndex, int targetIndex) {

        int index = getIndexFromQuickOrder(res, startIndex, endIndex);

        if (index == targetIndex) {
            return res[targetIndex];
        }

        return index > targetIndex
                ? getKthLargestValue(res, startIndex, index - 1, targetIndex)
                : getKthLargestValue(res, index + 1, endIndex, targetIndex);

    }

    private int getIndexFromQuickOrder(int[] res, int startIndex, int endIndex) {

        int initValue = res[startIndex];
        int start = startIndex, end = endIndex + 1;
        while (true) {

            while (++start <= endIndex && res[start] > initValue);
            while (--end >= startIndex && res[end] < initValue);

            if (end <= start) {
                break;
            }

            int swap = res[start];
            res[start] = res[end];
            res[end] = swap;

        }

        res[startIndex] = res[end];
        res[end] = initValue;

        return end;

    }
}