package java01796.m01;

/**
 * @Author: alton
 * @Date: Created in 6/22/21 9:54 PM
 * @Description:
 *
 * 1796. Second Largest Digit in a String #138
 *
 * Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
 *
 * An alphanumeric string is a string consisting of lowercase English letters and digits.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dfa12321afd"
 * Output: 2
 * Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
 * Example 2:
 *
 * Input: s = "abc1111"
 * Output: -1
 * Explanation: The digits that appear in s are [1]. There is no second largest digit.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 *
 * Time complexity : O(N)
 * Space Complexity : O(1)
 *
 */
class Solution {
    public int secondHighest(String s) {

        int firstMax = -1, secondMax = -1;

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            if (temp <= 9 && temp >= 0) {
                if (temp > firstMax) {
                    secondMax = firstMax;
                    firstMax = temp;
                    continue;
                }

                if (temp > secondMax && temp < firstMax) {
                    secondMax = temp;
                }
            }
        }

        return secondMax;
    }
}
