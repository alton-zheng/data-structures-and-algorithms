package java01442;

/**
 * @Author: alton
 * @Date: Created in 5/18/21 1:41 PM
 * @Description:
 * 1442. Count Triplets That Can Form Two Arrays of Equal XOR #18
 * Given an array of integers arr.
 *
 * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
 *
 * Let's define a and b as follows:
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * Note that ^ denotes the bitwise-xor operation.
 *
 * Return the number of triplets (i, j and k) Where a == b.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,1,6,7]
 * Output: 4
 * Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
 * Example 2:
 *
 * Input: arr = [1,1,1,1,1]
 * Output: 10
 * Example 3:
 *
 * Input: arr = [2,3]
 * Output: 0
 * Example 4:
 *
 * Input: arr = [1,3,5,7,9]
 * Output: 3
 * Example 5:
 *
 * Input: arr = [7,11,12,9,5,2,7,17,22]
 * Output: 8
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[i] <= 10^8
 *
 * Time Complexity: O(N^3)
 * Space Complexity: O(N)
 * 	​
 * a = h[i] ^ h[j]
 * b = h[j] ^ h[k + 1]
 * ​
 */
class Solution3 {
    public int countTriplets(int[] arr) {

        int arrLen = arr.length;
        int[] help = new int[arrLen + 1];

        for (int i = 0; i < arrLen; i++) {
            help[i + 1] = help[i] ^ arr[i];
        }

        int res = 0;

        for (int i = 0; i < arrLen; i++) {
            for (int j = i + 1; j < arrLen; j++) {
                for (int k = j; k < arrLen; k++) {
                    if (help[i] == help[k + 1]) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}

/**
 * 因为此题已经被提纯到只要满足 help[i] == help[k+1] ，就说明对应的 i, j, k 满足要求，
 * 而  i < j <= k， 推断出  j = k - i
 * 因此 j 那层循环可以直接去掉
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 */
class Solution {
    public int countTriplets(int[] arr) {

        int arrLen = arr.length;
        int[] help = new int[arrLen + 1];

        for (int i = 0; i < arrLen; i++) {
            help[i + 1] = help[i] ^ arr[i];
        }

        int res = 0;
        for (int i = 0; i < arrLen; i++) {

            for (int k = i + 1; k < arrLen; k++) {
                if (help[i] == help[k+1]) {
                    res += k - i;
                }
            }

        }

        return res;
    }
}


