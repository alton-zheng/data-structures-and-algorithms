package java00423.m01;

/**
 * @Author: alton
 * @Date: Created in 7/13/21 8:42 PM
 * @Description:
 * 423. Reconstruct Original Digits from English #202
 *
 * Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "owoztneoer"
 * Output: "012"
 * Example 2:
 *
 * Input: s = "fviefuro"
 * Output: "45"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
 * s is guaranteed to be valid.
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 *
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Reconstruct Original Digits from English.
 * Memory Usage: 39.7 MB, less than 60.20% of Java online submissions for Reconstruct Original Digits from English.
 */
class Solution {
    public String originalDigits(String s) {

        // building hashmap letter -> its frequency
        char[] help = new char[26 + (int)'a'];
        for(char letter: s.toCharArray()) {
            help[letter]++;
        }

        // building hashmap digit -> its frequency
        int[] ten = new int[10];
        // letter "z" is present only in "zero"
        ten[0] = help['z'];
        // letter "w" is present only in "two"
        ten[2] = help['w'];
        // letter "u" is present only in "four"
        ten[4] = help['u'];
        // letter "x" is present only in "six"
        ten[6] = help['x'];
        // letter "g" is present only in "eight"
        ten[8] = help['g'];
        // letter "h" is present only in "three" and "eight"
        ten[3] = help['h'] - ten[8];
        // letter "f" is present only in "five" and "four"
        ten[5] = help['f'] - ten[4];
        // letter "s" is present only in "seven" and "six"
        ten[7] = help['s'] - ten[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        ten[9] = help['i'] - ten[5] - ten[6] - ten[8];
        // letter "n" is present in "one", "nine", and "seven"
        ten[1] = help['n'] - ten[7] - 2 * ten[9];

        // building output string
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < ten[i]; j++) {
                output.append(i);
            }
        }
        return output.toString();
    }
}
