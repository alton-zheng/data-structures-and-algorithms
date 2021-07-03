package java00451.m01;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: alton
 * @Date: Created in 7/3/21 11:22 AM
 * @Description:
 *
 * 451. Sort Characters By Frequency #170
 *
 * Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^5
 * s consists of English letters and digits.
 *
 * Time Complexity : O(len(s) + 2*123)
 * Space Complexity : O(123*log)
 * Runtime: 5 ms, faster than 96.80% of Java online submissions for Sort Characters By Frequency.
 * Memory Usage: 39.8 MB, less than 65.87% of Java online submissions for Sort Characters By Frequency.
 */
class Solution {
    public String frequencySort(String s) {

        // 122 为 z char 编码
        int[] help = new int[123];

        for (char c: s.toCharArray()) {
            help[c]++;
        }

        // 按字符出现的频率从高到底排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(122, (a, b) -> b[1] - a[1]);

        for (int i = 0; i < 123; i++) {
            // 排除未出现过的字符，减少 queue 的排序消耗
            if (help[i] > 0) {
                queue.add(new int[]{i, help[i]});
            }

        }

        StringBuilder sb = new StringBuilder();
        int[] cur;

        // 按频率高到低从 queque 中取出并写入到结果集中
        while (!queue.isEmpty()) {
            cur = queue.poll();
            while (cur[1] > 0) {
                sb.append((char)cur[0]);
                cur[1]--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("abababz"));
    }
}
