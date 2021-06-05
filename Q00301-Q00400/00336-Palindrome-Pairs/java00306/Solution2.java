package java00306;

import java.util.*;

/**
 * @Author: alton
 * @Date: Created in 6/5/21 9:11 AM
 * @Description:
 * 336. Palindrome Pairs #76
 *
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 *
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lower-case English letters.
 *
 * Time Complexity: O(n * m^2)
 * Space Complexity: O(n * m)
 *
 * Runtime: 38 ms, faster than 77.04% of Java online submissions for Palindrome Pairs.
 * Memory Usage: 40.7 MB, less than 92.24% of Java online submissions for Palindrome Pairs.
 * 
 */
class Solution2 {

    Map<String, Integer> help = new HashMap<>();

    public List<List<Integer>> palindromePairs(String[] words) {

        int wordsLen = words.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < wordsLen; i++) {
            String item = new StringBuilder(words[i]).reverse().toString();
            help.put(item, i);
        }


        for (int i = 0; i < wordsLen; i++) {
            int m = words[i].length();

            for (int j = 0; j <= m; j++) {

                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = find(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        res.add(Arrays.asList(i, leftId));
                    }
                }

                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = find(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        res.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }

        return res;
    }

    private int find(String word, int left, int right) {
        return help.getOrDefault(word.substring(left, right + 1), -1);
    }

    private boolean isPalindrome(String word, int left, int right) {

        int len = right - left + 1;

        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(left + i) != word.charAt(right - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().palindromePairs(new String[]{"abcd", "dcba"}));
    }
}
