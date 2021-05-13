package java00131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 5/13/21 1:40 PM
 * @Description:
 * 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 * Time Complexity: O(n*n^2)
 * Space Complexity: O(n^2)
 */
class Solution {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {

        n = s.length();
        f = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = true;
            }
        }

        /**
         * 从 s 后面字符逐步往前判断，对于s i 和 j 位置字符（j > i）2 字符是否相等
         * 且需要 s f[i + 1][j - 1] 相等，含义举例说明：
         * e.g. abba
         * s:  i = 0, j = 4 时， a == a
         *     要求 i + 1 = 1, j - 1 = 2 , 即 ： b == b
         *     abba 为 true
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {

        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }

    }
}


/**
 * 带记忆的方式，性能差不多
 */
class Solution2 {
    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}