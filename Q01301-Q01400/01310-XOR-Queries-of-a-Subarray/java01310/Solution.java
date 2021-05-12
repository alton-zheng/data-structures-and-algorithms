package java01310;

/**
 * @Author: alton
 * @Date: Created in 5/12/21 8:34 AM
 * @Description:
 * 1310. XOR Queries of a Subarray
 * Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array containing the result for the given queries.
 *
 *
 * Example 1:
 *
 * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * Output: [2,7,14,8]
 * Explanation:
 * The binary representation of the elements in the array are:
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * The XOR values for queries are:
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 * Example 2:
 *
 * Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * Output: [8,0,4,4]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 3 * 10^4
 * 1 <= arr[i] <= 10^9
 * 1 <= queries.length <= 3 * 10^4
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] < arr.length
 *

 */

/**
 *  这种算法是最简单的
 *  性能最差， 无论是时间复杂度和空间复杂度都很差劲。
 *  Time Complexity: O(m*n)
 *  Space Complexity: O(n)
 */
class Solution2 {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int qLen = queries.length;
        int[] res = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int[] array = queries[i];
            for (int j = array[0]; j <= array[1]; j++) {
                res[i] ^= arr[j];
            }
        }

        return  res;
    }
}


/**
 *
 *  Time Complexity: O(n + m)
 *  Space Complexity: O(n)
 */
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int qLen = queries.length;

        /**
         * 定义辅助 xor 数组
         * 首位元素值等于 0
         * xor[1] = 0 ^ arr[0]
         * xor[2] = 0 ^ arr[0] ^ arr[1]
         * 根据结合律可以推断出
         * x[i] = xor[i - 1] ^ arr[i - 1]
         */
        int[] xor = new int[qLen + 1];
        xor[0] = 0;
        for (int i = 1; i < qLen + 1; i++) {
            xor[i] = xor[i - 1] ^ arr[i - 1];
        }

        int[] res = new int[qLen];
        // 根据异或结合律，推断出下列逻辑
        for (int i = 0; i < qLen; i++) {
            res[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
        }

        return res;

    }
}