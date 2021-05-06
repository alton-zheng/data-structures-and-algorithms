/**
 * 67. Add Binary
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 * Time Complexity: O(max(len(a), len(b)))
 * Space Complexity: O(1)
 */
class Solution {

    public String addBinary(String a , String b) {

        int alen = a.length(), blen = b.length();
        int m = Math.max(alen,blen), carry = 0;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < m; i++) {
            carry += i < alen ? (a.charAt(alen - 1 - i) - '0') : 0;
            carry += i < blen ? (b.charAt(blen - 1 - i) - '0') : 0;
            res.append((char)(carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            res.append('1');
        }

        res.reverse();

        return res.toString();

    }
}