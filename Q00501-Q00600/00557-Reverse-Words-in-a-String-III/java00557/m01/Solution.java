package java00557.m01;

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
 * Space Complexity : O(len(wrod))
 * Runtime: 3 ms, faster than 88.67% of Java online submissions for Reverse Words in a String III.
 * Memory Usage: 39.7 MB, less than 46.84% of Java online submissions for Reverse Words in a String III.
 */
class Solution {
    public String reverseWords(String s) {
        String[] help = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String str: help) {
            StringBuilder temp = new StringBuilder();
            temp.append(str).reverse();
            sb.append(temp).append(" ");
        }

        return sb.toString().substring(0, sb.length() - 1);

    }
}
