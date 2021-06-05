package java00717;

/**
 * @Author: alton
 * @Date: Created in 6/5/21 9:28 PM
 * @Description:
 *
 * 717. 1-bit and 2-bit Characters #80
 *
 * We have two special characters:
 *
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
 *
 *
 *
 * Example 1:
 *
 * Input: bits = [1,0,0]
 * Output: true
 * Explanation: The only way to decode it is two-bit character and one-bit character.
 * So the last character is one-bit character.
 * Example 2:
 *
 * Input: bits = [1,1,1,0]
 * Output: false
 * Explanation: The only way to decode it is two-bit character and two-bit character.
 * So the last character is not one-bit character.
 *
 *
 * Constraints:
 *
 * 1 <= bits.length <= 1000
 * bits[i] is either 0 or 1.
 *
 *
 *
 * Method two: Greed
 * If the three characters are 0, 10, and 11,
 * all zeros in the bits array represent the end position of a character (whether it is one bit or two bits).
 * Therefore, whether the last bit is a one-bit character depends only on the number of consecutive ones to its left
 * (i.e., the number of ones between the positions where the penultimate zero occurs;
 * if there is only one zero in the bits array, then the length of the array is minus one).
 * If there is an even number of 1's, the last bit is a one-bit character.
 * If there is an odd number of 1's, the last bit is two bits.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for 1-bit and 2-bit Characters.
 * Memory Usage: 38.3 MB, less than 48.48% of Java online submissions for 1-bit and 2-bit Characters.
 * 
 */
class Solution2 {
    public boolean isOneBitCharacter(int[] bits) {

        // Let's start at the second place of len - 2 （len = bits.length）
        int index = bits.length - 2;
        while (index >= 0 && bits[index] > 0) {

            // That's 1, index - 1
            index--;

        }

        // bits.length - index
        // The number of 1s between the reciprocal two zeros of bits
        return (bits.length - index) % 2 == 0;

    }
}
