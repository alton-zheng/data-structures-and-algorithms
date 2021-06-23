package java0038.m01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 6/22/21 8:30 PM
 * @Description:
 * Offer 38-zi-fu-chuan-de-pai-lie-lcof #136
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * Time Complexity : O(N* N!)
 * Space Complexity : O(N)
 *
 * 执行用时： 14 ms, 在所有 Java 提交中击败了 56.42% 的用户
 * 内存消耗： 42.8 MB, 在所有 Java 提交中击败了 73.71% 的用户
 */
class Solution {

    private List<String> list;
    private boolean[] visit;
    public String[] permutation(String s) {
        list = new ArrayList<>();

        int len = s.length();
        visit = new boolean[len];
        char[] source = s.toCharArray();

        Arrays.sort(source);

        StringBuilder help = new StringBuilder();
        backtrack(source, 0, len, help);

        String[] res = new String[list.size()];

        for (int l = 0; l < list.size(); l++) {
            res[l] = list.get(l);
        }

        return res;


    }

    private void backtrack (char[] source, int i, int n, StringBuilder help) {
        if (i == n) {
            list.add(help.toString());
            return;
        }

        for (int j = 0; j < n; j++) {

            if (visit[j] || (j > 0 && !visit[j - 1] && source[j] == source[j - 1])) {
                continue;
            }

            visit[j] = true;
            help.append(source[j]);
            backtrack(source, i + 1, n, help);
            help.deleteCharAt(help.length() - 1);
            visit[j] = false;
        }
    }
}