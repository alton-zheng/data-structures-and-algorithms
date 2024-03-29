package java01143.m01;

/**
 * @Author: alton
 * @Date: Created in 2022/9/4 16:40
 * @Description:
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 * Time Complexity: O(x*y)
 * Space Complexity: O(x*y)
 * Runtime: 5 ms, faster than 99.65% of Java online submissions for Longest Common Subsequence.
 * Memory Usage: 42.8 MB, less than 63.93% of Java online submissions for Longest Common Subsequence.
 *
 * 1143. Longest Common Subsequence #463
 *
 * 这种方法会超时， 可以通过缓存值进行处理，会思考就行，不要太纠结，此题重点考察 dp, 在方法二中进行了编写
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int text1Len = text1.length(), text2Len = text2.length();

        // 确认边界条件
        if (text1Len == 0 || text2Len == 0) {
            return 0;
        }

        char[] text1A = text1.toCharArray(), text2A = text2.toCharArray();
        return longestCommonSubsequence(text1A, text1Len, text2A, text2Len);
    }

    private int longestCommonSubsequence(char[] text1A, int index1, char[] text2A, int index2) {

        if (index1 == 0 || index2 == 0) {
            return 0;
        }

        if (text1A[index1 - 1] == text2A[index2 - 1]) {
            return longestCommonSubsequence(text1A, index1 - 1, text2A, index2 - 1) + 1;
        }

        return Math.max(
                longestCommonSubsequence(text1A, index1, text2A, index2 - 1),
                longestCommonSubsequence(text1A, index1 - 1, text2A, index2)
        );
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
    }
}
