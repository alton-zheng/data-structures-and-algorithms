package java00005.m01;

/**
 * 执行用时： 24 ms , 在所有 Java 提交中击败了 88.35% 的用户
 * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 90.62% 的用户
 */
class Solution {
    public String longestPalindrome(String s) {

        // 定义开始位置 left, 结束位置 right
        int left = 0, right = 0;

        // 开始遍历 s
        for (int i = 0; i < s.length(); i++) {


            // 原地为中心
            int len1 = judgePalinedromeCenter(s, i, i);

            // 原地和原地后一个字符，两者为中心
            int len2 = judgePalinedromeCenter(s, i, i + 1);

            // 上面两种判断方式，取大值
            int len = Math.max(len1, len2);


            // 当 len > 之前 right - left 时
            // 说明 i 位置或 i 和 i + 1 位置为中心的回文串更长
            if (len > right - left) {
                // 更新 left
                left = i - (len - 1) / 2;

                // 更新 right
                right = i + len / 2;
            }
        }

        // 返回 [left, right]
        return s.substring(left, right + 1);

    }

    /**
     * 返回： 回文串的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int judgePalinedromeCenter(String s, int left, int right) {

        // 循环判断回文范围 [left, right] 为中心左右扩
        // 直到扩不动为止
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        // 返回 len 长度 right - left - 1
        return right - left - 1;
    }
}
