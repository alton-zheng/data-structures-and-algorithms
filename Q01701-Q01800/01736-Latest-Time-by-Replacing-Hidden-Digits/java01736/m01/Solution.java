package java01736.m01;


/**
 * @Author: alton
 * @Date: Created in 2021/7/23 下午11:17
 * @Description:
 * 1736. Latest Time by Replacing Hidden Digits #234
 *
 * You are given a string time in the form of hh:mm, where some of the digits in the string are hidden (represented by ?).
 *
 * The valid times are those inclusively between 00:00 and 23:59.
 *
 * Return the latest valid time you can get from time by replacing the hidden digits.
 *
 *
 *
 * Example 1:
 *
 * Input: time = "2?:?0"
 * Output: "23:50"
 * Explanation: The latest hour beginning with the digit '2' is 23 and the latest minute ending with the digit '0' is 50.
 * Example 2:
 *
 * Input: time = "0?:3?"
 * Output: "09:39"
 * Example 3:
 *
 * Input: time = "1?:22"
 * Output: "19:22"
 *
 *
 * Constraints:
 *
 * time is in the format hh:mm.
 * It is guaranteed that you can produce a valid time from the given string.
 *
 * Time Complexity： O(1)
 * Space Complexity: O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Latest Time by Replacing Hidden Digits.
 * Memory Usage: 36.8 MB, less than 97.15% of Java online submissions for Latest Time by Replacing Hidden Digits.
 */
class Solution {
    public String maximumTime(String time) {

        char[] help = time.toCharArray();

        help[0] = help[0] != '?' ? help[0] : ((help[1] != '?' && help[1] >= '4') ? '1' : '2');

        help[1] = help[1] != '?' ? help[1] : ((help[0] == '2') ? '3' : '9');

        help[3] = help[3] != '?' ? help[3] : '5';

        help[4] = help[4] != '?' ? help[4] : '9';

        return String.valueOf(help);
    }
}
