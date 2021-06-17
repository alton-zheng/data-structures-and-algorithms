package java01374.m01;

/**
 * @Author: alton
 * @Date: Created in 6/17/21 4:43 PM
 * @Description:
 *
 * Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
 *
 * The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: "pppz"
 * Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".
 * Example 2:
 *
 * Input: n = 2
 * Output: "xy"
 * Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many other valid strings such as "ag" and "ur".
 * Example 3:
 *
 * Input: n = 7
 * Output: "holasss"
 *
 *
 * Constraints:
 *
 * 1 <= n <= 500
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * Runtime: 1 ms, faster than 65.64% of Java online submissions for Generate a String With Characters That Have Odd Counts.
 * Memory Usage: 36.3 MB, less than 69.55% of Java online submissions for Generate a String With Characters That Have Odd Counts.
 */
class Solution {
    public String generateTheString(int n) {

        StringBuilder res = new StringBuilder();
        int start = 0;
        if (n % 2 == 0) {
            res.append("e");
            start = 1;
        }

        for (int i = start; i < n; i++) {
           res.append("o");
        }

        return res.toString();
    }
}
