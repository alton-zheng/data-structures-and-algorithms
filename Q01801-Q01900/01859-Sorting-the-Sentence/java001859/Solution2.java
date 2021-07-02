package java001859;

/**
 * @Author: alton
 * @Date: Created in 5/24/21 1:26 PM
 * @Description:
 * - [ ] 1859. Sorting the Sentence #38
 *
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.
 *
 * A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
 *
 * For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
 * Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "is2 sentence4 This1 a3"
 * Output: "This is a sentence"
 * Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
 * Example 2:
 *
 * Input: s = "Myself2 Me1 I4 and3"
 * Output: "Me Myself and I"
 * Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 200
 * s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
 * The number of words in s is between 1 and 9.
 * The words in s are separated by a single space.
 * s contains no leading or trailing spaces.
 *
 * Time Complexity: O(N) ： N 为 words 的个数
 * Space Complexity: O(S): S 为 words 的个数
 * 暴力解法
 */
class Solution2 {
    public String sortSentence(String s) {

        String[] strs = s.split(" ");
        int strsLen = strs.length;
        String[] help = new String[strsLen];

        for (int i = 0; i < strsLen; i++) {
            String temp = strs[i];
            int offset = Integer.valueOf(temp.substring(temp.length() - 1));
            help[offset - 1] = temp.substring(0, temp.length() - 1);
        }

        StringBuilder res  = new StringBuilder();


        for (int i = 0; i < help.length; i++) {
            res.append(help[i]);
            if (i != help.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}
