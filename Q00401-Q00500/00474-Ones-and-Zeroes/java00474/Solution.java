package java00474;

/**
 * @Author: alton
 * @Date: Created in 6/6/21 6:29 AM
 * @Description:
 * 474. Ones and Zeroes #82
 *
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 * Example 2:
 *
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 *
 * Time Complexity: O(lmn+L)
 * Space Complexity: O(mn)
 *
 * Runtime: 31 ms, faster than 99.02% of Java online submissions for Ones and Zeroes.
 * Memory Usage: 37.6 MB, less than 93.44% of Java online submissions for Ones and Zeroes.
 *
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;
        int[][] help = new int[m + 1][n + 1];

        int[] zerosOnes = new int[2];
        int zeroes = 0, ones = 0;
        for (int l = 0; l < len; l++) {
            zerosOnes = getZerosOnes(strs[l]);
            zeroes = zerosOnes[0];
            ones = zerosOnes[1];

            for (int z = m; z >= zeroes; z--) {
                for (int o = n; o >= ones; o--) {
                    help[z][o] = Math.max(help[z][o], help[z - zeroes][o - ones] + 1);
                }
            }
        }

        return help[m][n];
    }

    private int[] getZerosOnes(String str) {
        int[] res = new int[2];

        for (char c: str.toCharArray()) {
            res[c - '0']++;
        }

        return res;
    }

}
