package java00338;

/**
 * @Author: alton
 * @Date: Created in 5/21/21 5:41 PM
 * @Description:
 * 338. Counting Bits #28
 * Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].
 *
 *
 *
 * Example 1:
 *
 * Input: num = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: num = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * Constraints:
 *
 * 0 <= num <= 105
 *
 * DP
 * Time Complexity: O(len)
 * Space Complexity: O(len) 包括了返回的数组锁占用的空间，如果不包含它，则 O(1)
 */
class Solution {
    public int[] countBits(int num) {

        int[] res  = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;

    }
}
