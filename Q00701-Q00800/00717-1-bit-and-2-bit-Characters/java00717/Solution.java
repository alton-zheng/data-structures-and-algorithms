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
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * if 1 -> 2
 * if 0 -> 1
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for 1-bit and 2-bit Characters.
 * Memory Usage: 38 MB, less than 93.06% of Java online submissions for 1-bit and 2-bit Characters.
 *
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {

        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }

        return i == bits.length - 1;

    }
}
