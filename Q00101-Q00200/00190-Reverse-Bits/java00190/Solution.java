package java00190;

/**
 * @Author: alton
 * @Date: Created in 6/7/21 2:42 PM
 * @Description:
 *
 * 190. Reverse Bits #85
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *
 *
 * Constraints:
 *
 * The input must be a binary string of length 32
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Bit by bit upside down
 *
 * Runtime: 1 ms, faster than 98.06% of Java online submissions for Reverse Bits.
 * Memory Usage: 38.5 MB, less than 66.13% of Java online submissions for Reverse Bits.
 *
 */
public class Solution {

    private static final int M1 = 0x55555555;
    private static final int M2 = 0x33333333;
    private static final int M4 = 0x0f0f0f0f;
    private static final int M8 = 0x00ff00ff;

    public int reverseBits(int n) {

        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;

        return n >>> 16 | n << 16;

    }

}
