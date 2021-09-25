package java00583.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/9/25 10:02 上午
 * @Description:
 *
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 * 示例：
 *
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 * 提示：
 *
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 *
 *
 */
class Solution {

    public int minDistance(String word1, String word2) {
        int w1L = word1.length(), w2L = word2.length();

        int[][] help = new int[w1L + 1][w2L + 1];
        for (int i = 1; i <= w1L; i++) {
            help[i][0] = i;
        }

        for (int j = 1; j <= w2L; j++) {
            help[0][j] = j;
        }

        for (int i = 1; i <= w1L; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= w2L; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    help[i][j] = help[i - 1][j - 1];
                } else {
                    help[i][j] = Math.min(help[i - 1][j], help[i][j - 1]) + 1;
                }
            }
        }

        return help[w1L][w2L];
    }
}

