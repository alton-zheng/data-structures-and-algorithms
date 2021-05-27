package java00461;

/**
 * @Author: alton
 * @Date: Created in 5/27/21 2:33 PM
 * @Description:
 * 461. Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * Example 2:
 *
 * Input: x = 3, y = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 0 <= x, y <= 231 - 1
 *
 * Time Complexity: O()
 * Space Complexity: O()
 *
 */
class Solution {

    public int hammingDistance(int x, int y) {

        int res = 0;

        int temp = x ^ y;

        while (temp != 0) {
            temp &= temp - 1;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(5, 6));
    }

}
