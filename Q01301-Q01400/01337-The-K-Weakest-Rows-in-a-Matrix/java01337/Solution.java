package java01337;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/1/21 5:20 PM
 * @Description:
 *
 * 1337. The K Weakest Rows in a Matrix #64
 *
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 *
 * A row i is weaker than a row j if one of the following is true:
 *
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 *
 *
 *
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 *
 * Time Complexity : O(n * logn)
 * Space Complexity : O(k)
 * Runtime: 2 ms, faster than 57.04% of Java online submissions for The K Weakest Rows in a Matrix.
 * Memory Usage: 39.8 MB, less than 62.99% of Java online submissions for The K Weakest Rows in a Matrix.
 */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        List<List<Integer>> help = new ArrayList<>();
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(getOnes(mat[i]));
            temp.add(i);
            help.add(temp);
        }

        Collections.sort(help, (i1, i2) ->
                i1.get(0) != i1.get(0) ? i1.get(1) - i2.get(1) : i1.get(0) - i2.get(0));

        for (int i = 0; i < k; i++) {
            ans[i] = help.get(i).get(1);
        }
        return ans;
    }

    /**
     * binary search
     * @param arr
     * @return
     */
    private int getOnes(int[] arr) {
        int low = 0, hight = arr.length;

        while (low < hight) {
            int mid = low + (hight - low) / 2;

            if (arr[mid] == 1) {
                low = mid + 1;
            } else {
                hight = mid;
            }
        }

        return low;
    }
}