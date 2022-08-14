package java01417;

/**
 * @Author: alton
 * @Date: Created in 5/26/21 3:36 PM
 * @Description:
 * 1417. Reformat The String #46
 *
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 *
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
 *
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 * Example 3:
 *
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 * Example 4:
 *
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 * Example 5:
 *
 * Input: s = "ab123"
 * Output: "1a2b3"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 *
 * Time Complexity: O(2n)
 * Space Complexity: O(1)
 *
 */
class Solution {
    public String reformat(String s) {

        int sLen = s.length();
        int lowercaseLetters = 0;
        for (char c: s.toCharArray()) {
            if (c - 'a' <= 25 && c - 'a' >= 0) {
                lowercaseLetters++;
            }
        }

        int lowercaseStartIndex = 0;
        if (lowercaseLetters - (sLen - lowercaseLetters) == 1 || lowercaseLetters - (sLen - lowercaseLetters) == 0) {
            lowercaseStartIndex = 0;
        } else if (lowercaseLetters - (sLen - lowercaseLetters) == -1){
            lowercaseStartIndex = 1;
        } else {
            return "";
        }

        int digitIndex = lowercaseStartIndex == 0 ? 1 : 0;
        char[] res = new char[sLen];
        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                res[lowercaseStartIndex] = c;
                lowercaseStartIndex += 2;
            } else {
                res[digitIndex] = c;
                digitIndex += 2;
            }
        }

        return new String(res);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().reformat("covid2019"));
    }
}
