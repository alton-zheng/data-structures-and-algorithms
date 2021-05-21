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
 * 动态规划
 * Time Complexity: O(len)
 * Space Complexity: O(len)
 */
class Solution3 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++){
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }

            res[i] = res[i - highBit] + 1;
        }

        return res;
    }
}
