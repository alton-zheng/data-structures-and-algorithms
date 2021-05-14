package java00693;

/**
 * @Author: alton
 * @Date: Created in 5/14/21 1:41 PM
 * @Description:
 * 693. Binary Number with Alternating Bits
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: true
 * Explanation: The binary representation of 5 is: 101
 * Example 2:
 *
 * Input: n = 7
 * Output: false
 * Explanation: The binary representation of 7 is: 111.
 * Example 3:
 *
 * Input: n = 11
 * Output: false
 * Explanation: The binary representation of 11 is: 1011.
 * Example 4:
 *
 * Input: n = 10
 * Output: true
 * Explanation: The binary representation of 10 is: 1010.
 * Example 5:
 *
 * Input: n = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 *
 * Time Complexity: O()
 * Space Complexity: O()
 */
class Solution {
    public boolean hasAlternatingBits(int n) {

        String s = Integer.toBinaryString(n);

        char pre = s.charAt(0);
        char cur;

        for(int i = 1; i < s.length(); i++) {
            cur = s.charAt(i);
            if (pre == cur) {
                return false;
            }
            pre = cur;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasAlternatingBits(5));
    }
}
