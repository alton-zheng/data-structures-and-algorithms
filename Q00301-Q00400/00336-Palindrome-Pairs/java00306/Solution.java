package java00306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Runtime: 58 ms, faster than 54.62% of Java online submissions for Palindrome Pairs.
 * Memory Usage: 45.5 MB, less than 46.94% of Java online submissions for Palindrome Pairs.
 *
 */
class Solution {

    class Node {
        int flag;
        int[] ch = new int[26];

        Node() {
            flag = -1;
        }
    }

    List<Node> tree = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {

        int wordsLen = words.length;

        List<List<Integer>> res = new ArrayList<>();
        tree.add(new Node());

        for (int i = 0; i < wordsLen; i++){
            insert(words[i], i);
        }

        for (int n = 0; n < wordsLen; n++){
            int m = words[n].length();

            for (int j = 0; j <= m; j++) {

                if (isPalindrome(words[n], j, m - 1)) {
                    int left = find(words[n], 0, j - 1);
                    if (left != -1 && left != n) {
                        res.add(Arrays.asList(n, left));
                    }
                }

                if (j != 0 && isPalindrome(words[n], 0, j - 1)) {
                    int right = find(words[n], j, m - 1);
                    if (right != -1 && right != n) {
                        res.add(Arrays.asList(right, n));
                    }
                }
            }
        }

        return res;

    }

    private int find(String word, int left, int right) {

        int level = 0;
        for (int i = right; i >= left; i--) {
            int x = word.charAt(i) - 'a';
            if (tree.get(level).ch[x] == 0) {
                return -1;
            }

            level = tree.get(level).ch[x];
        }

        return tree.get(level).flag;

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

    private void insert(String word, int id) {

        int level = 0;

        for (char ch: word.toCharArray()) {
            int x = ch - 'a';
            if (tree.get(level).ch[x] == 0) {
                tree.add(new Node());
                tree.get(level).ch[x] = tree.size() - 1;
            }

            level = tree.get(level).ch[x];
        }

        tree.get(level).flag = id;

    }

    public static void main(String[] args) {
        new Solution().palindromePairs(new String[]{"abcd","dcba"});
    }
}
