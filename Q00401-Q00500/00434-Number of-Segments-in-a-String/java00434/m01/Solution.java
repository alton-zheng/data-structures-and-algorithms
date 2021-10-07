package java00434.m01;

/**
 * @Author: Alton
 * @Date: 2021/10/7 8:56 上午
 * @Description:
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 */
class Solution {
    public int countSegments(String s) {
        int len = s.length();

        char[] sChar = s.toCharArray();

        int res = 0;
        for (int i = 0; i < len; i++) {
            if ((i == 0 || sChar[i - 1] == ' ') && sChar[i] != ' ') {
                res++;
            }
        }

        return res;
    }
}
