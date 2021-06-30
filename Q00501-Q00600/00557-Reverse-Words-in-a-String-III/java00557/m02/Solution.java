package java00557.m02;

/**
 * @Author: alton
 * @Date: Created in 6/30/21 11:13 AM
 * @Description:
 *
 * 557. Reverse Words in a String III #162
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 *
 * Time Complexity :O(N)
 * Space Complexity : O(len(word))
 * Runtime: 4 ms, faster than 80.27% of Java online submissions for Reverse Words in a String III.
 * Memory Usage: 39.8 MB, less than 38.45% of Java online submissions for Reverse Words in a String III.
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder help = new StringBuilder();
        String[] temp = help.append(s).reverse().toString().split(" ");

        help = new StringBuilder();
        for (int i = temp.length - 1; i > -1; i--) {
            help.append(temp[i]);
            if (i != 0) {
                help.append(" ");
            }
        }

        return help.toString();
    }
}
