package java00917.m02;

import java.util.Stack;

/**
 * @Author: alton
 * @Date: Created in 7/11/21 5:02 PM
 * @Description:
 *
 * 917. Reverse Only Letters #197
 *
 * Given a string s, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * Note:
 *
 * s.length <= 100
 * 33 <= s[i].ASCIIcode <= 122
 * s doesn't contain \ or "
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * Runtime: 1 ms, faster than 43.06% of Java online submissions for Reverse Only Letters.
 * Memory Usage: 37 MB, less than 79.51% of Java online submissions for Reverse Only Letters.
 *
 */
class Solution {
    public String reverseOnlyLetters(String s) {

        StringBuilder res = new StringBuilder();
        int len = s.length();
        char[] arr = s.toCharArray();
        int j = len - 1;

        for (int i = 0; i < len; i++) {
            if (Character.isLetter(arr[i])) {
                while (!Character.isLetter(arr[j])) {
                    j--;
                }
                res.append(arr[j--]);

            } else {
                res.append(arr[i]);
            }
        }

        return res.toString();
    }
}
