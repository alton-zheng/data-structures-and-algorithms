/**
 * 1720. Decode XORed Array
 * There is a hidden integer array arr that consists of n non-negative integers.
 *
 * It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].
 *
 * You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].
 *
 * Return the original array arr. It can be proved that the answer exists and is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: encoded = [1,2,3], first = 1
 * Output: [1,0,2,1]
 * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * Example 2:
 *
 * Input: encoded = [6,2,7,3], first = 4
 * Output: [4,2,0,7,4]
 *
 * Constraints:
 *
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 *
 * 异或运算具有如下性质：
 *
 * - 异或运算满足交换律和结合律；
 *
 * - 任意整数和自身做异或运算的结果都等于 0，即 x ^ x = 0;
 *
 * - 任意整数和 0 做异或运算的结果都等于其自身，即 x ^ 0 = x。
 *
 * &nbsp;
 *
 * 当 1 <= i < n 时，有 encoded[i - 1] = arr[i - 1] ^ arr[i]。在等号两边同时异或 arr[i - 1]，可以得到 arr[i] = arr[i - 1] ^ encoded[i - 1]，计算过程如下：
 *
 * - encoded[i - 1]	= arr[i - 1] ^ arr[i]
 * - encoded[i - 1] ^ arr[i - 1] = arr[i - 1] ^ arr[i - 1] ^ arr[i]
 * - encoded[i - 1] ^ arr[i - 1] = 0 ^ arr[i]
 * - encoded[i - 1] ^ arr[i - 1] = arr[i]
 *
 *
 * 因此当  1 <= i < n  时，有 `arr[i] = arr[i - 1] ^ encoded[i - 1]`
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int[] decode(int[] encoded, int first) {

        if (encoded == null) {
            return null;
        }

        int[] res = new int[encoded.length + 1];

        int start = 1;
        res[0] = first;

        for (int i : encoded) {
            res[start] = res[start - 1] ^ encoded[start - 1];
            start++;
        }

        return res;
    }
}