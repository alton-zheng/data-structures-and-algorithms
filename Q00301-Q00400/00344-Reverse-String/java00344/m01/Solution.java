package java00344.m01;

/**
 * @Author: alton
 * @Date: Created in 7/3/21 5:28 PM
 * @Description:
 * 344. Reverse String #171
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 *
 * Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int left, int right) {
        char swap = s[left];
        s[left] = s[right];
        s[right] = swap;
    }

}
