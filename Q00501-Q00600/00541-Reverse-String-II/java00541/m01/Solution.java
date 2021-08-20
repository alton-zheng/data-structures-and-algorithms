package java00541.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/20 下午12:15
 * @Description:
 *
 * 541. Reverse String II
 *
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^4
 *
 * Time Complexity: O(n/2)
 * Space Complexity: O(1)
 *
 * Runtime: 1 ms, faster than 76.12% of Java online submissions for Reverse String II.
 * Memory Usage: 39.1 MB, less than 49.64% of Java online submissions for Reverse String II.
 */
class Solution {
    public String reverseStr(String s, int k) {
        int l = s.length();
        char[] source = s.toCharArray();
        for(int i = 0; i < l; i+= 2*k) {

            int left = i, right = i + k - 1 >= l ? l - 1 : i + k - 1;

            while (left < right) {
                char swap = source[left];
                source[left] = source[right];
                source[right] = swap;
                left++;
                right--;
            }
        }

        return new String(source);
    }
}
